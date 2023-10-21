//@Suppress("DSL_SCOPE_VIOLATION") // uncomment it if gradle version < 8.2
plugins {
    alias(libs.plugins.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.meetpeople"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.meetpeople"
        minSdk = 28
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
}

dependencies {
    /** DI **/

    /** Core **/
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    /** Test **/
    testImplementation(libs.junit)
    /** Android test **/
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}