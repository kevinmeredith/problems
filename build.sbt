scalaVersion := "2.12.3"

libraryDependencies += "org.scalameta" %% "munit" % "0.7.22" % Test
libraryDependencies += "org.scalameta" %% "munit-scalacheck" % "0.7.22" % Test

testFrameworks += new TestFramework("munit.Framework")