sbtPlugin := false

organization := "com.siderakis"

name := "futuraes"

scalaVersion := "2.10.2"

libraryDependencies ++= Seq(
  "javax.servlet" % "servlet-api" % "2.5" % "provided",
   "com.google.appengine"%"appengine-api-1.0-sdk"%"1.8.8"
)

publishMavenStyle := true

publishTo := Some(Resolver.file("Local", Path.userHome / "siderakis.github.com" / "maven" asFile)(Patterns(true, Resolver.mavenStyleBasePattern)))