/* basic project info */
name := "jerkson"

organization := "com.cloudphysics"

version := "0.5.1-SNAPSHOT"

licenses := Seq(
  ("The MIT License", url("http://codahale.com/mit.txt"))
)

scmInfo := Some(
  ScmInfo(
    url("https://github.com/cphylabs/jerkson"),
    "scm:git:https://github.com/cphylabs/jerkson.git",
    Some("scm:git:git@github.com:cphylabs/jerkson.git")
  )
)

/* scala versions and options */
scalaVersion := "2.10.1"

crossScalaVersions ++= Seq(
  "2.10.0"
  // "2.9.3-RC1",
  // "2.9.2",
  // "2.9.1", "2.9.1-1",
  // "2.9.0", "2.9.0-1"
)

// These options will be used for *all* versions.
scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-encoding", "UTF-8",
  "-optimise"   // this option will slow your build
)

scalacOptions ++= Seq(
  "-Yclosure-elim",
  "-Yinline"
)

// These language flags will be used only for 2.10.x.
// Uncomment those you need, or if you hate SIP-18, all of them.
scalacOptions <++= scalaVersion map { sv =>
  if (sv startsWith "2.10") List(
    "-Xverify",
    "-Ywarn-all",
    "-feature",
    "-language:postfixOps",
    "-language:reflectiveCalls",
    "-language:implicitConversions",
    "-language:higherKinds",
    "-language:existentials"
  )
  else Nil
}

javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation")

/* dependencies */
libraryDependencies ++= Seq(
  "org.codehaus.jackson" % "jackson-core-asl" % "1.9.12",
  "org.codehaus.jackson" % "jackson-mapper-asl" % "1.9.12"
  // "com.codahale" %% "simplespec" % "0.6.0" % "test"
)

libraryDependencies <+= scalaVersion {
  "org.scala-lang" % "scala-reflect" % _
}


/* testing */
parallelExecution in Test := false

/* sbt behavior */
logLevel in compile := Level.Warn

traceLevel := 5

offline := false

/* publishing */
publishMavenStyle := true

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT")) Some(
    "snapshots" at nexus + "content/repositories/snapshots"
  )
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <developers>
    <developer>
      <id>ymasory</id>
      <name>Yuvi Masory</name>
      <email>yuvi@cloudphysics.com</email>
    </developer>
  </developers>
)

// Josh Suereth's step-by-step guide to publishing on sonatype
// http://www.scala-sbt.org/using_sonatype.html

