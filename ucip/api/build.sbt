import AssemblyKeys._ // put this at the top of the file



organization := "me.ouertani.sjca"

name := "ucip.api"

version := "1.0"

scalaVersion := "2.9.2"

crossScalaVersions := Seq("2.9.1", "2.9.2")





resolvers += "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"
 

libraryDependencies += "javax" % "javaee-api" % "6.0" % "provided"

seq(assemblySettings: _*)

assembleArtifact in packageScala := false
