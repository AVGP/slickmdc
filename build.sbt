lazy val root = (project in file(".")).
  settings(
    name := "slickmdc",
    organization := "de.geekonaut",
    version := "1.0.0",
    scalaVersion := "2.11.4",
    publishMavenStyle := true,
    pomIncludeRepository := { _ => false },
    publishTo := {
      val nexus = "https://oss.sonatype.org/"
      if (isSnapshot.value)
        Some("snapshots" at nexus + "content/repositories/snapshots")
      else
        Some("releases"  at nexus + "service/local/staging/deploy/maven2")
    },
    pomExtra := (
      <url>http://jsuereth.com/scala-arm</url>
      <licenses>
        <license>
          <name>MIT</name>
          <url>http://www.opensource.org/licenses/mit-license.php</url>
          <distribution>repo</distribution>
        </license>
      </licenses>
      <scm>
        <url>git@github.com:avgp/slickmdc.git</url>
        <connection>scm:git:git@github.com:avgp/slickmdc.git</connection>
      </scm>
      <developers>
        <developer>
          <id>geekonaut</id>
          <name>Martin Splitt</name>
          <url>http://geekonaut.de</url>
        </developer>
      </developers>)
  )



libraryDependencies ++= Seq(
  "com.typesafe.slick"                  %% "slick"                    % "3.1.1",
  "com.typesafe.scala-logging"          %% "scala-logging"            % "3.4.0",
  "org.slf4j"                           %  "log4j-over-slf4j"         % "1.7.21"
)
