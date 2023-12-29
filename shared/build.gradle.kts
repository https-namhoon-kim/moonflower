import org.jetbrains.compose.ExperimentalComposeLibrary

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("org.jetbrains.kotlin.native.cocoapods")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("com.squareup.sqldelight")
    kotlin("plugin.serialization")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //shared compose
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                @OptIn(ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)

                // database
                implementation(libs.squareup.sqldelight)
                implementation(libs.squareup.sqldelight.coroutines.extensions)

                implementation(libs.ktor.core)
                implementation(libs.ktor.serialization)
                implementation(libs.ktor.serialization.json)

            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlinx.test)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.ktor.android)
                // database
                implementation(libs.squareup.sqldelight.android)
            }
        }

        val iosMain by getting {
            dependencies {
                implementation(libs.ktor.ios)
                // database
                implementation(libs.squareup.sqldelight.native)

            }
        }
    }
}

android {
    namespace = "com.kmm.moonflower"
    compileSdk = libs.versions.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    //add the commonMain Resources
    sourceSets["main"].resources.setSrcDirs(
        listOf(
//            "src/androidMain/resources",
            "src/commonMain/resources"
        )
    )
}

sqldelight {
    database("AppDatabase") {
        packageName = "com.kmm.moonflower.database"
        sourceFolders = listOf("sqldelight")
    }
}