ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.8.3"

lazy val root = (project in file("."))
  .settings(
    name := "lambda-calculus-interpreter"
  )

libraryDependencies ++=Seq(
  "org.scalacheck"    %% "scalacheck"          % "1.19.0" % Test,
)