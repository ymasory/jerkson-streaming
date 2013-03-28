# Jerkson + Scala 2.10 + Streaming Iteration #

[Jerkson](https://github.com/codahale/jerkson) has only been published for
Scala versions as high as 2.9.1 and does not support streaming iteration.

## Differences from upstream Jerkson ##

- Streaming iteration is supported.
- sbt instead of Maven.
- Tests have been deleted, since sbt cannot run
  [simplespec](https://github.com/SimpleFinance/simplespec) tests.
- Minor tweaks to get compilation in 2.10.

## Install ##

- This version of Jerkson is hosted on
[Maven Central](http://central.maven.org/maven2/com/cloudphysics/).
- From sbt:

  ```scala
  libraryDependencies += "com.cloudphysics" % "jerkson_2.10" % "0.5.1"
  ```
- From Maven:

  ```xml
  <dependency>
    <groupId>com.cloudphysics</groupId>
    <artifactId>jerkson_2.10</artifactId>
    <version>0.5.1</version>
  </dependency>
  ```

## Build ##

- Just compile:
  ```sh
  $ cd jerkson
  $ ./sbt compile
  ```
- Publish:
  ```sh
  $ ./sbt publish
  ```

## Contact ##

Repo maintained by [Yuvi Masory](http://yuvimasory.com).  
[ymasory@gmail.com](ymasory@gmail.com)
