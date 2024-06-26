plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                val koinVersion = "3.2.0"
                implementation("io.insert-koin:koin-core:$koinVersion")
                implementation("io.insert-koin:koin-test:$koinVersion")
                implementation("io.insert-koin:koin-android:$koinVersion")

                implementation(project.dependencies.platform("io.insert-koin:koin-bom:3.5.3"))
                implementation("io.insert-koin:koin-compose")
            }
        }
        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }
}

android {
    namespace = "com.sebstydi.sebstydi"
    compileSdk = 34

    defaultConfig {
        minSdk = 27
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(libs.androidx.ui.graphics.android)
    implementation(libs.androidx.lifecycle.viewmodel.android)
}
