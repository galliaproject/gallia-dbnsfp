// gallia-dbnsfp

// ===========================================================================
lazy val root = (project in file("."))
  .settings(
    organizationName     := "Gallia Project",
    organization         := "io.github.galliaproject", // *must* match groupId for sonatype
    name                 := "gallia-dbnsfp",
    version              := "0.3.0",    
    homepage             := Some(url("https://github.com/galliaproject/gallia-dbnsfp")),
    scmInfo              := Some(ScmInfo(
        browseUrl  = url("https://github.com/galliaproject/gallia-dbnsfp"),
        connection =     "scm:git@github.com:galliaproject/gallia-dbnsfp.git")),
    licenses             := Seq("BSL 1.1" -> url("https://github.com/galliaproject/gallia-dbnsfp/blob/master/LICENSE")),
    description          := "A Scala library for data manipulation" )
  .settings(GalliaCommonSettings.mainSettings:_*)

// ===========================================================================    
lazy val galliaVersion = "0.3.0"

// ---------------------------------------------------------------------------
libraryDependencies += "io.github.galliaproject" %% "gallia-core" % galliaVersion // in turns depends on aptus-core

// ===========================================================================
sonatypeRepository     := "https://s01.oss.sonatype.org/service/local"
sonatypeCredentialHost :=         "s01.oss.sonatype.org"        
publishMavenStyle      := true
publishTo              := sonatypePublishToBundle.value

// ===========================================================================
