import sbt._
import sbt.Keys._

object ProjectBuild extends Build {
  import Dependencies._
  import Repos._

  lazy val baseSettings = Seq(
    name := "AkkaRemoteObjectsAsMessages",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.10.3",
    scalacOptions ++= Seq("-deprecation", "-feature"),
    resolvers ++= Seq(typesafeRelease),
    libraryDependencies ++= Seq(akkaActor, akkaRemote)
    )

  lazy val baseProject = Project(
    id = "base",
    base = file("."),
    settings = Project.defaultSettings,
    aggregate = Seq(localProject, remoteProject)
    )

  lazy val commonProject = Project(
    id = "common",
    base = file("Common"),
    settings = Project.defaultSettings
    )

  lazy val localProject = Project(
    id = "local",
    base = file("HelloLocal"),
    settings = Project.defaultSettings ++ baseSettings
    ).dependsOn(commonProject)

  lazy val remoteProject = Project(
    id = "remote",
    base = file("HelloRemote"),
    settings = Project.defaultSettings ++ baseSettings
    ).dependsOn(commonProject)

  object Versions {
    val akka = "2.2.3"
  }

  object Dependencies {
    val akkaActor = "com.typesafe.akka" %% "akka-actor" % Versions.akka
    val akkaRemote = "com.typesafe.akka" %% "akka-remote" % Versions.akka
  }

  object Repos {
    val typesafeRelease = "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases"
  }
}
