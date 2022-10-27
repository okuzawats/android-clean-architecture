plugins {
  id("com.android.application") version libs.versions.android.gradle.plugin apply false
  id("com.android.library") version libs.versions.android.gradle.plugin apply false
  id("org.jetbrains.kotlin.android") version libs.versions.kotlin apply false
}

buildscript {
  dependencies {
    classpath(libs.hilt.android.gradle.plugin)
  }
}