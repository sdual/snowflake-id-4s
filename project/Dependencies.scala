import sbt._

object Dependencies {
  val scalaTest = "org.scalatest" %% "scalatest" % "3.2.11"

  val snowflakeIdDependencies = Seq(
    scalaTest % Test
  )
}
