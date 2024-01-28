// See README.md for license details.

ThisBuild / scalaVersion     := "2.12.17"
ThisBuild / version          := "0.1.0"
ThisBuild / organization     := "dyf"


lazy val root = (project in file("."))
  .settings(
    name := "GCD",
    libraryDependencies ++= Seq(
      "edu.berkeley.cs" %% "chisel3" % "3.9-SNAPSHOT" ,
      "edu.berkeley.cs" %% "chiseltest" % "0.5-SNAPSHOT"
    ),
    dependencyOverrides += "edu.berkeley.cs" %% "firrtl" % "1.5-SNAPSHOT",
    scalacOptions ++= Seq(
      "-language:reflectiveCalls",
      "-deprecation",
      "-feature",
      "-Xcheckinit"
    ),
    addCompilerPlugin("edu.berkeley.cs" % "chisel3-plugin" % "3.9-SNAPSHOT" cross CrossVersion.full),
  )

