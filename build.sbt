// gallia-dbnsfp

// ===========================================================================
lazy val root = (project in file("."))
  .settings(
    name         := "gallia-dbnsfp",
    version      := "0.1.0" )
  .dependsOn(RootProject(file("../gallia-core")))

// ===========================================================================
scalacOptions in Compile ++= Seq( // TODO: more + inherit
  "-Ywarn-value-discard",
  "-Ywarn-unused-import")

// ===========================================================================
EclipseKeys.withSource := true
EclipseKeys.createSrc  := EclipseCreateSrc.Default

// ===========================================================================
