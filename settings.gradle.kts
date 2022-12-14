@file:Suppress("UnstableApiUsage")

pluginManagement {
  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
  }
}
enableFeaturePreview("VERSION_CATALOGS")
dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    google()
    mavenCentral()
  }
}
rootProject.name = "CleanArchitecture"
include(":app")
include(":ui")
include(":presentation")
include(":domain")
include(":data")
include(":data:remote")
include(":test")
