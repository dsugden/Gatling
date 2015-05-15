import io.gatling.sbt.GatlingPlugin

name := "Gatling"

version := "1.0"

scalaVersion := "2.11.6"

//scalaSource in Gatling := sourceDirectory.value / "test"

//
//unmanagedBase := baseDirectory.value / "custom_lib"

enablePlugins(GatlingPlugin)

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

//javaOptions in Gatling := overrideDefaultJavaOptions("-Xms1024m", "-Xmx2048m")

libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.2.0-SNAPSHOT" % "it,test"
libraryDependencies += "io.gatling" % "gatling-test-framework" % "2.2.0-SNAPSHOT" % "it,test"
