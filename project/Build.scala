import sbt._,Keys._

object Build extends Build {
  lazy val baseSettings = Seq(
    scalaVersion := "2.10.1",
    organization := "com.github.hexx",
    scalacOptions ++= Seq(
      "-deprecation",
      "-feature",
      "-unchecked",
      "-language:implicitConversions"
    )
  )

  lazy val dispatchClassicArgonaut = Project(
    id = "dispatch-classic-argonaut",
    base = file(".")
  ).settings(
    baseSettings ++ seq(
      name := "dispatch-classic-argonaut",
      version := "0.0.1",
      libraryDependencies ++= Seq(
        "net.databinder" %% "dispatch-core" % "0.8.9",
        "net.databinder" %% "dispatch-http" % "0.8.9",
        "io.argonaut" %% "argonaut" % "6.0-M4"
      ),
      initialCommands in console += Seq(
        "argonaut._",
        "Argonaut._",
        "dispatch.classic._",
        "dispatch.classic.argonaut.JsHttp._"
      ).map("import " + _ + "\n").mkString
    ) : _*
  )
}
