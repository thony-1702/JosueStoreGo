plugins {
    id("com.google.gms.google-services")
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "app.ecommerce.josuestorego"
    compileSdk = 35

    defaultConfig {
        applicationId = "app.ecommerce.josuestorego"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.viewpager2)
    implementation(libs.firebase.database)
    //implementation(libs.firebase.database.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation("com.google.code.gson:gson:2.10.1")

    // Firebase
    //implementation(platform("com.google.firebase:firebase-bom:33.1.1"))
    //implementation("com.google.firebase:firebase-auth-ktx")
    //implementation(libs.google.firebase.database.ktx)
    //implementation(libs.firebase.database.ktx)
    //implementation("com.google.android.gms:play-services-auth:21.2.0")

// ViewModel & LiveData
    //implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.2")
    //implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.2")
    //implementation("androidx.fragment:fragment-ktx:1.8.0")

// Navegación
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")

// Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.7.3")

// Glide (para imágenes)
    implementation("com.github.bumptech.glide:glide:4.16.0")

    //implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.tbuonomo:dotsindicator:5.1.0")
}