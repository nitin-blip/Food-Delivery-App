plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.google.gms.google.services)


    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")


    kotlin("plugin.serialization") version "2.0.0"
}

android {
    namespace = "com.example.zomato1app"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.zomato1app"
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
    implementation(libs.firebase.auth)
    implementation(libs.androidx.credentials)
    implementation(libs.androidx.credentials.play.services.auth)
    implementation(libs.googleid)
    implementation(libs.firebase.firestore.ktx)
    implementation(libs.firebase.firestore)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    //Glide
//    implementation("com.github.bump tech.glide:compose:4.16.0")
    implementation("com.github.bumptech.glide:compose:1.0.0-alpha.1")
    implementation("androidx.compose.material:material-icons-extended:1.7.8")



        //hilt All   Dependancy
    implementation("com.google.dagger:hilt-android:2.56.2")
    kapt("com.google.dagger:hilt-android-compiler:2.56.2")


    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    kapt("androidx.hilt:hilt-compiler:1.2.0")
    implementation ("com.google.dagger:hilt-android:2.51.1")
    kapt( "com.google.dagger:hilt-compiler:2.51.1")

    //coil dependancy
    implementation("io.coil-kt:coil-compose:2.6.0")
    //Naviagtion
    implementation("androidx.navigation:navigation-compose:2.8.0-beta06")

    val nav_version = "2.9.3"
    implementation("androidx.navigation:navigation-compose:$nav_version")

    //Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
    //payment  getway
    implementation("com.razorpay:checkout:1.6.40")

    //pager
    implementation("com.google.accompanist:accompanist-pager:0.28.0")
    implementation("com.google.accompanist:accompanist-pager-indicators:0.28.0")

    //custom bottom navigation bar
    implementation("com.canopas.compose-animated-navigationbar:bottombar:1.0.1")

    //lottie  for place order  dialog
    implementation("com.airbnb.android:lottie-compose:4.2.0")
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.32.0")

    //splashScreen
    implementation("androidx.core:core-splashscreen:1.0.1")
    implementation("androidx.compose.material3:material3:1.3.2")

    implementation("androidx.compose.foundation:foundation:1.5.0")
    implementation("androidx.compose.foundation:foundation-layout:1.5.0")
    implementation("androidx.compose.material3:material3:1.3.2")

    implementation("androidx.compose.ui:ui:1.5.0")
    implementation("androidx.compose.material3:material3:1.1.0")
    implementation("androidx.navigation:navigation-compose:2.5.3")


//    implementation("com.google.firebase:firebase-bom:34.2.0")
//    implementation("com.google.firebase:firebase-storage")
//    implementation("com.google.firebase:firebase-firestore-ktx:25.1.4")
//    implementation("com.google.firebase:firebase-auth-ktx:32.0.0")




}