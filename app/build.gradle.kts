plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs")
    id("kotlin-parcelize")
    id ("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.example.jetpack_compose"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.jetpack_compose"
        minSdk = 30
        targetSdk = 34
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
//    kotlinOptions {
//        freeCompilerArgs += "-Xno-optimize"
//    }


    buildFeatures {
        viewBinding = true
        dataBinding = true
        compose = true
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.datatransport:transport-runtime:3.3.0")
    implementation("com.google.android.gms:play-services-maps:19.0.0")
    implementation("androidx.databinding:databinding-runtime:8.7.0")
    implementation("androidx.databinding:databinding-adapters:8.7.0")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("com.google.firebase:firebase-components:18.0.1")
    implementation( "androidx.test.services:storage:1.5.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    implementation("com.github.bumptech.glide:glide:4.16.0")
    kapt("com.github.bumptech.glide:compiler:4.16.0")
   // implementation("com.google.accompanist:accompanist-glide:8.7.0")

    implementation ("com.google.dagger:hilt-android:2.52")
    kapt ("com.google.dagger:hilt-android-compiler:2.52")

    implementation("androidx.fragment:fragment-ktx:1.8.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.8.2")
    implementation("androidx.navigation:navigation-ui-ktx:2.8.2")

    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")

    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.6")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.6")

    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.paging:paging-runtime-ktx:3.3.2")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")

    implementation ("androidx.compose.ui:ui:1.7.3")
    implementation ("androidx.compose.material:material:1.7.3")
    implementation ("androidx.compose.ui:ui-tooling:1.7.3")
    implementation ("androidx.compose.compiler:compiler:1.5.15")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.7.3")
    implementation ("com.google.android.material:compose-theme-adapter:1.2.1")
    implementation ("androidx.paging:paging-compose:3.3.2")
    implementation ("androidx.compose.runtime:runtime-livedata:1.7.3")
    implementation ("androidx.compose.runtime:runtime:1.7.3")
    implementation ("androidx.compose.foundation:foundation:1.7.3")
    implementation ("androidx.compose.foundation:foundation-layout:1.7.3")
    implementation ("androidx.activity:activity-compose:1.9.2")
    implementation ("androidx.fragment:fragment-compose:1.8.4")
    implementation ("io.coil-kt:coil-compose:2.7.0")
    implementation ("androidx.navigation:navigation-compose:2.8.2")
    //implementation ("com.google.accompanist:accompanist-coil:0.17.0")
    implementation ("org.jetbrains.kotlin:kotlin-stdlib:2.0.20")
}
