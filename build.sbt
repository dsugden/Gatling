import io.gatling.sbt.GatlingPlugin

name := "Gatling"

version := "1.0"

scalaVersion := "2.11.6"

scalaSource in Gatling := baseDirectory.value / "user-files/simulations"

unmanagedBase := baseDirectory.value / "custom_lib"

enablePlugins(GatlingPlugin)

libraryDependencies ++= Seq(
  "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.1.5" % "test",
"io.gatling"            % "gatling-test-framework"    % "2.1.5" % "test")

fork in Test := true
