ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.7"

libraryDependencies += "com.lihaoyi" %% "os-lib" % "0.11.6"

lazy val root = (project in file("."))
  .settings(
    name := "aoc-2025"
  )


