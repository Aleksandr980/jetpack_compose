// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        mavenCentral()

    }

    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.52")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.8.2")
        classpath("com.android.tools.build:gradle:8.1.4")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.10")
        classpath ("androidx.compose.ui:ui:1.7.3")
        classpath ("androidx.compose.material:material:1.7.3")

    }
}
plugins {
    id("com.android.application") version ("8.2.0") apply false
    id("com.android.library") version ("8.2.0") apply false
    id("org.jetbrains.kotlin.android") version ("2.0.10") apply false
    id ("org.jetbrains.kotlin.plugin.compose") version ("2.0.0") apply false

}
