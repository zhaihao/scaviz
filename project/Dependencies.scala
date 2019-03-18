/*
 * Copyright (c) 2019.
 * OOON.ME ALL RIGHTS RESERVED.
 * Licensed under the Mozilla Public License, version 2.0
 * Please visit http://ooon.me or mail to zhaihao@ooon.me
 */

import sbt._

/**
  * Dependencies
  *
  * @author zhaihao
  * @version 1.0 2019-02-18 13:29
  */
object Dependencies extends AutoPlugin {
  override def requires = empty
  override def trigger  = allRequirements

  object autoImport {
    lazy val base = "me.ooon" %% "base" % "1.0.33"

    lazy val scalatest = "org.scalatest"     %% "scalatest"     % "3.0.6" % Test
    lazy val os_lib    = "com.lihaoyi"       %% "os-lib"        % "0.2.8"
    lazy val sqlite    = "org.xerial"        % "sqlite-jdbc"    % "3.25.2"
    lazy val requests  = "com.lihaoyi"       %% "requests"      % "0.1.7"
    lazy val play_json = "com.typesafe.play" %% "play-json"     % "2.7.1"
    lazy val scraper   = "net.ruippeixotog"  %% "scala-scraper" % "2.1.0"
    //lazy val spire     = "org.typelevel"     %% "spire"         % "0.16.0"
    lazy val scalaz    = "org.scalaz"        %% "scalaz-core"   % "7.2.27"
    lazy val vegas     = "org.vegas-viz"     %% "vegas"         % "0.3.12-om"
    lazy val squants   = "org.typelevel"     %% "squants"       % "1.4.0"

    lazy val log = Seq(
      "com.typesafe.scala-logging" %% "scala-logging"  % "3.9.2",
      "ch.qos.logback"             % "logback-classic" % "1.2.3"
    )

    lazy val chill = Seq(
      "com.twitter" %% "chill"           % "0.9.3",
      "com.twitter" %% "chill-bijection" % "0.9.3"
    )

    // https://github.com/ghik/silencer
    lazy val silencer = Seq(
      compilerPlugin("com.github.ghik" %% "silencer-plugin" % "0.6"),
      "com.github.ghik" %% "silencer-lib" % "0.6"
    )

    lazy val slick = Seq(
      "com.typesafe.slick" %% "slick"          % "3.3.0",
      "com.typesafe.slick" %% "slick-hikaricp" % "3.3.0",
      "com.typesafe.slick" %% "slick-codegen"  % "3.3.0",
      "com.typesafe.slick" %% "slick-testkit"  % "3.3.0" % Test
    )

    lazy val breeze = Seq(
      "org.scalanlp" %% "breeze"         % "1.0-RC2",
      "org.scalanlp" %% "breeze-natives" % "1.0-RC2",
      "org.scalanlp" %% "breeze-viz"     % "1.0-RC2"
    )

    val excludes = Seq(
      ExclusionRule("org.slf4j", "slf4j-log4j12"),
      ExclusionRule("log4j", "log4j")
    )

    val overrides = Seq()
  }

}
