plugins {
    alias(libs.plugins.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt.android)
}

android {
    namespace = "com.meetpeople"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.meetpeople"
        minSdk = 28
        versionCode = 1
        versionName = "0.0.1"

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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    /** DataStore **/
    implementation(libs.datastore)
    /** Serialization **/
    implementation(libs.kotlin.serialization)
    /** Network **/
    implementation(platform(libs.okhttp.bom))
    implementation(libs.bundles.network)
    /** DI **/
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    /** Core **/
    implementation(libs.bundles.android.core)
    /** Test **/
    testImplementation(libs.junit)
    /** Android test **/
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}