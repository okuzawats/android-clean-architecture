plugins {
  id("com.android.library")
  id("org.jetbrains.kotlin.android")
  id("com.google.dagger.hilt.android")
  id("kotlin-kapt")
}

android {
  namespace = "com.okuzawats.cleanarchitecture.ui"
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

dependencies {
  implementation(project(":presentation"))

  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.activity.ktx)
  implementation(libs.androidx.activity.compose)
  implementation(libs.androidx.compose.runtime.livedata)
  implementation(libs.androidx.compose.material)
  implementation(libs.compose.ui)
  implementation(libs.compose.ui.tooling.preview)
  debugImplementation(libs.compose.ui.tooling)
  debugImplementation(libs.compose.ui.test.manifest)
  androidTestImplementation(libs.compose.ui.test.junit4)

  implementation(libs.uniflow.android)
  testImplementation(libs.uniflow.android.test)

  implementation(libs.coil.compose)

  implementation(libs.hilt.android)
  kapt(libs.hilt.compiler)

  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.test.ext.junit)
  androidTestImplementation(libs.androidx.test.espresso.core)
}