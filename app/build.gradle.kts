plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("com.google.gms.google-services")

}

android {
    namespace = "com.example.poparticlestest"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.poparticlestest"
        minSdk = 24
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures{
        viewBinding = true
    }
}

dependencies {
    implementation(platform("com.google.firebase:firebase-bom:32.7.2"))
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation ("com.google.firebase:firebase-common-ktx:20.1.2")
    implementation ("com.google.firebase:firebase-core:21.1.1")

    implementation ("com.google.firebase:firebase-perf-ktx:20.3.1")
    implementation ("androidx.test:core-ktx:1.5.0")
    implementation ("com.google.android.play:app-update-ktx:+")


    implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.0"))
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.recyclerview:recyclerview:1.3.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
    implementation("io.insert-koin:koin-android:2.1.6")
    implementation("io.insert-koin:koin-androidx-viewmodel:2.1.6")
    implementation("io.insert-koin:koin-core:2.1.6")


    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.7.3")
  //  implementation("org.koin:koin-android-architecture:0.8.2")

    implementation("androidx.navigation:navigation-ui-ktx:2.6.0")
    implementation("androidx.navigation:navigation-fragment-ktx:2.6.0")//ver

    implementation("com.squareup.retrofit2:converter-scalars:2.9.0")
  //  implementation("com.scwang.smart:refresh-layout-kernel:2.0.1")
  //  implementation("com.scwang.smart:refresh-header-classics:2.0.1")
  //  implementation("com.yarolegovich:discrete-scrollview:1.5.1")
  //  implementation ("androidx.navigation:navigation-ui-ktx:2.7.7")
  //  implementation ("androidx.navigation:navigation-fragment-ktx:2.7.7")

    implementation  ("com.squareup.retrofit2:converter-scalars:2.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation  ("com.google.code.gson:gson:2.8.9")

    implementation ("com.contentful.vault:core:3.2.5")
    implementation ("com.contentful.java:java-sdk:10.5.2")
    implementation ("org.mockito:mockito-core:2.25.0")

    implementation("com.airbnb.android:lottie:3.4.4")




}