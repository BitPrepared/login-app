plugins {
    alias(libs.plugins.application)
    alias(libs.plugins.kotlin)
}

android {
    compileSdk = 34
    namespace = "it.bitprepared.loginapp"

    defaultConfig {
        applicationId = "it.bitprepared.loginapp"
        minSdk = 15
        targetSdk = 34
        versionCode = 4
        versionName = "4.0"
        multiDexEnabled = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    
    dependencies {
        implementation(libs.androidx.appcompat)
        implementation(libs.androidx.multidex)
        implementation(libs.androidx.recyclerview)
        implementation(libs.androidx.constraintlayout)
        implementation(libs.mdc)
        implementation(libs.rxjava)
        implementation(libs.rxandroid)
    }
}

kotlin {
    jvmToolchain(17)
}