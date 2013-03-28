# Jerkson + Scala 2.10 + Streaming Iteration #

[Jerkson](https://github.com/codahale/jerkson) has only been published for
Scala versions as high as 2.9.1.

## Differences from upstream Jerkson ##
- This repo uses sbt not Maven.
- Tests have been deleted, since sbt cannot run
  [simplespec](https://github.com/SimpleFinance/simplespec) tests.
- Minor tweaks to get compilation in 2.10.

## Install ##
- This version of Jerkson is hosted on
[Maven Central](http://central.maven.org/maven2/com/cloudphysics/).
- From sbt:
  ```scala
  libraryDependencies += "com.cloudphysics" %% "jerkson" % "0.5.1"
  ```
- From Maven:
  ```xml
  <dependency>
    <groupId>com.cloudphysics</groupId>
    <artifactId>jerkson_2.10</artifactId>
    <version>0.5.1</version>
  </dependency>
  ```

## Contact ##
Repo maintained by [Yuvi Masory](http://yuvimasory.com).  
[ymasory@gmail.com](ymasory@gmail.com)
