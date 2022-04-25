import Dependencies._

lazy val commonSettings = Seq(
  organization := "com.github.sdual",
  version := "0.1",
  scalaVersion := "2.13.8"
)

lazy val snowflakeId = (project in file("snowflake-id"))
  .settings(
    commonSettings,
    name := "snowflake-id",
    libraryDependencies ++= snowflakeIdDependencies
  )
