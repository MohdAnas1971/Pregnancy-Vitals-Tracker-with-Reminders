plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)


    //@Hilt
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
   // id("org.jetbrains.kotlin.plugin.serialization") version "2.2.0"

}

android {
    namespace = "com.example.pregnancyvitalstracker"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.pregnancyvitalstracker"
        minSdk = 29
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


// ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.9.2")

// Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.9.0")

// Hilt
    implementation("com.google.dagger:hilt-android:2.57")
   // kapt("com.google.dagger:hilt-android-compiler:2.57")
    ksp("com.google.dagger:hilt-android-compiler:2.57")

    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

// Room (can stay on ksp)
    implementation("androidx.room:room-runtime:2.7.2")
    ksp("androidx.room:room-compiler:2.7.2")
    implementation("androidx.room:room-ktx:2.7.2")

// WorkManager
    implementation("androidx.work:work-runtime-ktx:2.10.2")

// Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.10.2")

}