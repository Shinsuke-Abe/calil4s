name := "Calil4S"

scalaVersion := "2.10.3"

organization := "com.github.Shinsuke-Abe"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "2.3.7" % "test",
  "net.databinder.dispatch" %% "dispatch-core" % "0.11.0",
  "org.json4s" %% "json4s-native" % "3.2.6"
)

scalacOptions in Test ++= Seq("-Yrangepos")

// Read here for optional dependencies:
// http://etorreborre.github.io/specs2/guide/org.specs2.guide.Runners.html#Dependencies

resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)

licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))

initialCommands := "import calil4s._"
