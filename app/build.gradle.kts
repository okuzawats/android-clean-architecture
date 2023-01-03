@file:Suppress("UnstableApiUsage")

plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
  id("com.google.dagger.hilt.android")
  id("kotlin-kapt")
  id("kotlinx-serialization")
  id("com.google.android.gms.oss-licenses-plugin")
}

android {
  namespace = "com.okuzawats.cleanarchitecture"
  compileSdk = libs.versions.android.compileSdk.get().toInt()

  defaultConfig {
    applicationId = "com.okuzawats.cleanarchitecture"
    minSdk = libs.versions.android.minSdk.get().toInt()
    targetSdk = libs.versions.android.targetSdk.get().toInt()
    versionCode = libs.versions.app.versionCode.get().toInt()
    versionName = libs.versions.app.versionName.get()

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables {
      useSupportLibrary = true
    }
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  kotlinOptions {
    jvmTarget = JavaVersion.VERSION_11.toString()
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = libs.versions.compose.ui.get()
  }
  packagingOptions {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
}

kapt {
  // for dagger hilt
  correctErrorTypes = true
}

hilt {
  enableExperimentalClasspathAggregation = true
}

dependencies {
  implementation(project(":ui"))
  implementation(project(":presentation"))
  implementation(project(":domain"))
  implementation(project(":data"))
  implementation(project(":data:remote"))

  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.appcompat)
  implementation(libs.androidx.lifecycle.runtime.ktx)
  implementation(libs.androidx.lifecycle.viewmodel.ktx)
  implementation(libs.androidx.lifecycle.viewmodel.compose)
  implementation(libs.androidx.activity.ktx)
  implementation(libs.androidx.activity.compose)
  implementation(libs.androidx.compose.material)
  androidTestImplementation(libs.androidx.test.ext.junit)
  androidTestImplementation(libs.androidx.test.espresso.core)

  implementation(libs.compose.ui)
  implementation(libs.compose.ui.tooling.preview)
  debugImplementation(libs.compose.ui.tooling)
  debugImplementation(libs.compose.ui.test.manifest)
  androidTestImplementation(libs.compose.ui.test.junit4)

  implementation(libs.play.services.oss.licenses)

  implementation(libs.hilt.android)
  kapt(libs.hilt.compiler)

  implementation(libs.kotlin.serialization)
  implementation(libs.retrofit)
  implementation(libs.retrofit.converter)
  implementation(libs.okhttp.core)
  implementation(libs.arrow.core)

  testImplementation(libs.junit)
}
