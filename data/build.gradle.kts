plugins {
  id("com.android.library")
  id("org.jetbrains.kotlin.android")
  id("com.google.dagger.hilt.android")
  id("kotlin-kapt")
  id("kotlinx-serialization")
}

android {
  namespace = "com.okuzawats.cleanarchitecture.data"
  compileSdk = libs.versions.android.compileSdk.get().toInt()

  defaultConfig {
    minSdk = libs.versions.android.minSdk.get().toInt()
    targetSdk = libs.versions.android.targetSdk.get().toInt()

    consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
  implementation(libs.hilt.android)
  kapt(libs.hilt.compiler)

  implementation(libs.kotlin.serialization)
  implementation(libs.retrofit)
  implementation(libs.retrofit.converter)
  implementation(libs.okhttp.core)
  implementation(libs.arrow.core)

  testImplementation(libs.junit)
}