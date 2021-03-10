plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-android-extensions")
    id("dagger.hilt.android.plugin")
    id("com.apollographql.apollo").version("2.5.4")
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.2")

    defaultConfig {
        applicationId = "com.tharindu.damintha.gapstarstest"
        minSdkVersion(16)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
    }

}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    //Hilt
    implementation("com.google.dagger:hilt-android:2.33-beta")
    kapt("com.google.dagger:hilt-compiler:2.33-beta")

    //Apollo client
    implementation("com.apollographql.apollo:apollo-runtime:2.5.4")
    implementation("com.apollographql.apollo:apollo-coroutines-support:2.5.4")
    implementation("com.apollographql.apollo:apollo-android-support:2.5.4")
    implementation("com.apollographql.apollo:apollo-http-cache:2.5.4")

    //Stetho
    implementation("com.facebook.stetho:stetho:1.5.1")
    implementation("com.facebook.stetho:stetho-okhttp3:1.5.1")


    //live data
    val livedata_version = "2.3.0"
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$livedata_version")
    implementation("androidx.lifecycle:lifecycle-common-java8:$livedata_version")
    implementation("androidx.lifecycle:lifecycle-reactivestreams-ktx:$livedata_version")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$livedata_version")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$livedata_version")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$livedata_version")
    implementation("androidx.fragment:fragment-ktx:1.3.0")
    implementation("androidx.activity:activity-ktx:1.2.0")

    //Swipe refresh
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")


    //Glide
    implementation("com.github.bumptech.glide:glide:4.12.0")
    kapt("com.github.bumptech.glide:compiler:4.12.0")


    //Core libs
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.4.31")
    implementation("androidx.core:core-ktx:1.3.2")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")

    //Test
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
    androidTestImplementation("androidx.test:core-ktx:1.3.0")
}

apollo {
    generateKotlinModels.set(true)
}

