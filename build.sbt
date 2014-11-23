import io.gatling.sbt.GatlingPlugin
import io.gatling.sbt.GatlingPlugin.Gatling

name := "Gatling"

version := "1.0"

scalaVersion := "2.10.4"

scalaSource in Gatling := baseDirectory.value / "user-files/simulations"

unmanagedBase := baseDirectory.value / "custom_lib"

val test = project.in(file("."))
  .enablePlugins(GatlingPlugin)
  .settings(libraryDependencies ++= Seq(
  "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.0.3" % "test",
  "io.gatling" % "test-framework" % "1.0" % "test")
  )

fork in Test := true
