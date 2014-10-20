name := "Calil4S"

scalaVersion := "2.11.2"

crossScalaVersions := Seq("2.10.1", "2.11.2")

organization := "com.github.Shinsuke-Abe"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "2.4.2" % "test",
  "net.databinder.dispatch" %% "dispatch-core" % "0.11.0",
  "org.json4s" %% "json4s-native" % "3.2.10"
)

scalacOptions in Test ++= Seq("-Yrangepos")

// Read here for optional dependencies:
// http://etorreborre.github.io/specs2/guide/org.specs2.guide.Runners.html#Dependencies

resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)

licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))

initialCommands := "import calil4s._"
