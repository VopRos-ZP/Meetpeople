plugins {
    alias(libs.plugins.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlin.safeargs)
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "${JavaVersion.VERSION_17}"
    }
    buildFeatures {
        viewBinding = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.2"
    }
}

dependencies {
    /** DataStore **/
    implementation(libs.datastore)
    /** Serialization **/
    implementation(libs.kotlin.serialization)
    /** Network **/
    implementation(platform(libs.okhttp.bom))
    implementation(libs.bundles.okhttp)
    implementation(libs.bundles.retrofit)
    implementation(libs.bundles.ktor)
    /** DI **/
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    /** Core **/
    implementation(libs.bundles.android.core)
    /** Compose **/
    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)
    debugImplementation(libs.compose.ui.tooling)
    /** Navigation **/
    implementation(libs.bundles.navigation)
    ksp(libs.compose.destinations.ksp)
    /** Test **/
    testImplementation(libs.junit)
    /** Android test **/
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}