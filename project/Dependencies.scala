import sbt._

object Dependencies {
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.1.1"
  lazy val jsoup = "org.jsoup" % "jsoup" % "1.11.2"
  lazy val logger = "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2"
  lazy val logbackCore = "ch.qos.logback" % "logback-core" % "1.2.3"
  lazy val logbackClassic = "ch.qos.logback" % "logback-classic" % "1.2.3"
  lazy val typesafeconfig = "com.typesafe" % "config" % "1.4.0"
}
