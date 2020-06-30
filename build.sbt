import Dependencies._

lazy val commonSettings = Seq(
  version := "0.1-SNAPSHOT",
  organization := "com.xml.analyzer",
  organizationName := "analyzer",
  scalaVersion := "2.12.11",
  test in assembly := {}
)

lazy val root = (project in file(".")).
   settings(commonSettings: _*).
    settings(
     assemblyJarName in assembly := "xml_analyzer.jar",
     mainClass in assembly := Some("com.xml.analyzer.Analyzer"),
     name := "xml_analyzer",
     libraryDependencies ++= Seq(scalaTest, jsoup, logger, logbackCore, logbackClassic, typesafeconfig)
  )



