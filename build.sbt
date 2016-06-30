lazy val root = (project in file(".")).
  settings(
    name := "slickmdc",
    organization := "de.geekonaut",
    version := "1.0.0",
    scalaVersion := "2.11.4"
  )

libraryDependencies ++= Seq(
  "com.typesafe.slick"                  %% "slick"                    % "3.1.1",
  "com.typesafe.scala-logging"          %% "scala-logging"            % "3.4.0",
  "org.slf4j"                           %  "log4j-over-slf4j"         % "1.7.21"
)
