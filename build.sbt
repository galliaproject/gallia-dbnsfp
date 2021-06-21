// gallia-dbnsfp

// ===========================================================================
// TODO: inherit these from core

// ---------------------------------------------------------------------------
lazy val scala213 = "2.13.4"
lazy val scala212 = "2.12.13"

// ---------------------------------------------------------------------------
lazy val supportedScalaVersions = List(scala213, scala212)

// ===========================================================================
lazy val root = (project in file("."))
  .settings(
    name               := "gallia-dbnsfp",
    version            := "0.2.0",
    mainClass          := Some("galliaexample.dbnsfp.DbNsfpDriver"),
    scalaVersion       := supportedScalaVersions.head,
    crossScalaVersions := supportedScalaVersions)

// ===========================================================================
lazy val galliaVersion = "0.2.0"

libraryDependencies += "io.github.galliaproject" %% "gallia-core" % galliaVersion // in turns depends on aptus-core
    
// ===========================================================================
// TODO: more + inherit from core
scalacOptions in Compile ++=
  Seq("-Ywarn-value-discard") ++
  (scalaBinaryVersion.value match {
    case "2.13" => Seq("-Ywarn-unused:imports")
    case _      => Seq("-Ywarn-unused-import" ) })

// ===========================================================================
