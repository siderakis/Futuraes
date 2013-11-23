import sbtappengine.Plugin.{AppengineKeys => gae}

sbtPlugin := true

organization := "com.siderakis"

name := "Futuraes"

scalaVersion := "2.10.2"

libraryDependencies ++= Seq(
  "javax.servlet" % "servlet-api" % "2.5" % "provided",
  "org.mortbay.jetty" % "jetty" % "6.1.22" % "container"
)

appengineSettings

publishMavenStyle := true

publishTo := Some(Resolver.file("Local", Path.userHome / "siderakis.github.com" / "maven" asFile)(Patterns(true, Resolver.mavenStyleBasePattern)))