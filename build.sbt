lazy val `cats-redis` = (project in file("."))
  .settings(
    organization := "io.cedis",
    name := "cedis",
    scalaVersion := "2.12.8",
    scalacOptions += "-Ypartial-unification",
    libraryDependencies ++= List(
      "org.typelevel"        %% "cats-core"   % "1.5.0",
      "org.typelevel"        %% "cats-effect" % "1.1.0",
      "redis.clients"        % "jedis"        % "3.0.0",
      "com.github.mpilquist" %% "simulacrum"  % "0.14.0",
      "org.scalatest"        %% "scalatest"   % "3.0.5" % Test
    ),
    scalacOptions ++= List(
      "-target:jvm-1.8",
      "-feature",
      "-encoding",
      "UTF-8",
      "-unchecked",
      "-deprecation",
      "-language:higherKinds",
      "-Xlint",
      "-Ypartial-unification",
      "-Ywarn-dead-code",
      "-Ywarn-infer-any",
      "-Ywarn-nullary-override",
      "-Ywarn-unused:implicits",
      "-Ywarn-unused:imports",
      "-Ywarn-unused:locals",
      "-Ywarn-unused:params",
      "-Ywarn-unused:patvars",
      "-Ywarn-unused:privates",
      "-Ywarn-value-discard"
    ),
    addCompilerPlugin("org.spire-math"  %% "kind-projector" % "0.9.8"),
    addCompilerPlugin("org.scalamacros" % "paradise"        % "2.1.0" cross CrossVersion.full),
  )
