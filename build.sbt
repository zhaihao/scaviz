import sbt.Keys.scalacOptions
// global
scalaVersion in Global := "2.12.8"
organization in Global := "me.ooon"

scalacOptions in Global ++= Seq("-unchecked", "-deprecation", "-feature", "-Xfatal-warnings")
resolvers in Global += "Local Maven Repository" at "file://" + Path.userHome.absolutePath + "/.m2/repository"
resolvers in Global += Resolver.url("ooon ivy repo", url("https://repo.ooon.me/release"))(
  Resolver.ivyStylePatterns)
externalResolvers in Global := Resolver.combineDefaultResolvers(resolvers.value.toVector,
                                                                mavenCentral = true)

libraryDependencies in Global ++= Seq(base, scalatest)
libraryDependencies in Global ++= log
excludeDependencies in Global ++= excludes
dependencyOverrides in Global ++= overrides

scmInfo in Global := Some(
  ScmInfo(url("https://github.com/zhaihao/scaviz"), "git@github.com:zhaihao/scaviz.git"))
git.remoteRepo in Global := scmInfo.value.get.connection

cancelable in Global := true
//

lazy val root = (project in file("."))
  .settings(
    moduleName := "scaviz",
    name       := "scaviz",
    libraryDependencies ++= Seq().flatten,
    libraryDependencies ++= Seq(play_json, os_lib),
    scalacOptions in (Compile, doc) ++= Seq(
      "-diagrams",
      "-implicits",
      "-groups",
      "-doc-title",
      description.value,
      "-doc-version",
      scalaVersion.value,
      "-sourcepath",
      baseDirectory.in(LocalRootProject).value.getAbsolutePath,
      "-doc-source-url",
      scmInfo.value.get.browseUrl + "/tree/master€{FILE_PATH}.scala"
    )
  )

val ROOT = config("root")
lazy val docs = (project in file("docs"))
  .enablePlugins(SiteScaladocPlugin, ParadoxSitePlugin, ParadoxMaterialThemePlugin, GhpagesPlugin)
  .settings(
    moduleName := "docs",
    name       := "scaviz - Documents",
    ParadoxMaterialThemePlugin.paradoxMaterialThemeSettings(Paradox),
    previewLaunchBrowser := false,
    previewFixedPort     := Some(9000),
    previewFixedIp       := Some("0.0.0.0"),
    ghpagesNoJekyll      := true,
    excludeFilter in ghpagesCleanSite := new FileFilter {

      def accept(f: File) =
        (ghpagesRepository.value / "CNAME").getCanonicalPath == f.getCanonicalPath
    },
    sourceDirectory in Paradox := sourceDirectory.value / "main" / "paradox",
    paradoxProperties in Paradox ++= Map(
      "scaladoc.base_url"   -> "http://scaviz.ooon.me/api/",
      "github.base_url"     -> "https://github.com/zhaihao/scaviz",
      "snip.build.base_dir" -> baseDirectory.value.getAbsolutePath,
      "snip.github_link"    -> "false"
    ),
    paradoxNavigationDepth in Paradox          := 3,
    sourceDirectory in Paradox in paradoxTheme := sourceDirectory.value / "main" / "paradox" / "_template",
    makeSite                                   := makeSite.dependsOn(paradox in Paradox).value,
    mappings in makeSite in Paradox ++= Seq(file("LICENSE") -> "LICENSE"),
    paradoxMaterialTheme in Paradox ~= {
      _.withColor("red", "teal")
        .withCopyright("© zhaihao")
        .withRepository(uri("https://github.com/zhaihao/scaviz"))
        .withSocial(uri("https://github.com/zhaihao"),
                    uri("https://twitter.com/zhaihaoooon"),
                    uri("https://www.facebook.com/zhaihaome"))
        .withLanguage(java.util.Locale.CHINESE)
        .withCustomStylesheet("assets/custom.css")
    },
    autoAPIMappings := true,
    SiteScaladocPlugin
      .scaladocSettings(ROOT, mappings in (Compile, packageDoc) in root, "api/"),
  )
