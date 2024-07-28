plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("kotlin-kapt")
}

android {
    namespace = "com.example.encoraassignment"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.encoraassignment"
        minSdk = 24
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

    buildFeatures{
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.converter.gson)
    implementation(libs.converter.scalars)
    implementation(libs.logging.interceptor)
    implementation(libs.converter.moshi)
    implementation(libs.retrofit2.kotlin.coroutines.adapter)
    implementation(libs.retrofit)
    implementation(libs.picasso)
    implementation(libs.adapter.rxjava2)
    implementation (libs.androidx.room.runtime) // Use the latest version
    //annotationProcessor (libs.room.compiler) // For Java projects

    // For Kotlin projects use kapt instead of annotationProcessor
    //noinspection KaptUsageInsteadOfKsp
    kapt (libs.room.compiler)
    implementation(libs.simple.xml)
    implementation(libs.converter.simplexml)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}