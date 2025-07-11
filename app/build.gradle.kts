plugins {
    alias(libs.plugins.application)
    alias(libs.plugins.kotlin)
}

android {
    compileSdk = 34
    namespace = "it.bitprepared.loginapp"

    defaultConfig {
        applicationId = "it.bitprepared.loginapp"
        minSdk = 19
        targetSdk = 34
        versionCode = 7
        versionName = "5.2"
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
    }
}

kotlin {
    jvmToolchain(17)
}
