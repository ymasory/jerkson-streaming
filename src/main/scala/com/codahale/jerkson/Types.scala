package com.codahale.jerkson

import org.codehaus.jackson.`type`.JavaType
import org.codehaus.jackson.map.`type`.{TypeFactory, ArrayType}
import scala.collection.JavaConversions.asScalaConcurrentMap
import java.util.concurrent.ConcurrentHashMap

private[jerkson] object Types {
  private val cachedTypes = asScalaConcurrentMap(new ConcurrentHashMap[Manifest[_], JavaType]())

  def build(factory: TypeFactory, manifest: Manifest[_]): JavaType =
    cachedTypes.getOrElseUpdate(manifest, constructType(factory, manifest))

  private def constructType(factory: TypeFactory, manifest: Manifest[_]): JavaType = {
    if (manifest.runtimeClass.isArray) {
      ArrayType.construct(factory.constructType(manifest.runtimeClass.getComponentType), null, null)
    } else {
      factory.constructParametricType(
        manifest.runtimeClass,
        manifest.typeArguments.map {m => build(factory, m)}.toArray: _*)
    }
  }
}
