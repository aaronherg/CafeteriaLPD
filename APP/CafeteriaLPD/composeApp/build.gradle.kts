import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)

    // Serializacion
    alias(libs.plugins.jetbrains.kotlin.serialization)
    // KSP
    alias(libs.plugins.ksp)
    // Room
    alias(libs.plugins.androidxRoom)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    sourceSets {
        androidMain.dependencies {
            implementation(libs.compose.uiToolingPreview)
            implementation(libs.androidx.activity.compose)


            // SplashScreen
            implementation(libs.androidx.core.splashscreen)
            // Koin
            implementation(libs.koin.android)
            // Ktor
            implementation(libs.ktor.client.okhttp)

        }
        commonMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.compose.components.resources)
            implementation(libs.compose.uiToolingPreview)
            implementation(libs.androidx.lifecycle.runtimeCompose)


            // Navegación
            implementation(libs.jetbrains.navigation.compose)
            // Serialización
            implementation(libs.kotlinx.serialization.json)
            // ViewModel
            implementation(libs.lifecycle.viewmodel.compose)
            // Room
            implementation(libs.androidx.room.runtime)
            implementation(libs.androidx.sqliteBundled)
            // Koin
            implementation(project.dependencies.platform(libs.koin.bom))
            implementation(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)
            // Ktor
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.negotiation)
            implementation(libs.kotlin.serialization)
            // Datetime
            implementation(libs.kotlinx.datetime)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        iosMain.dependencies {

            // Ktor
            implementation(libs.ktor.client.darwin)
        }
    }
}

android {
    namespace = "com.aarondevs.cafeterialpd"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.aarondevs.cafeterialpd"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    debugImplementation(compose.uiTooling)

    // Ktor
    implementation(libs.androidx.core.i18n)
    //Room
    add("kspAndroid", libs.androidx.room.compiler)
    add("kspIosSimulatorArm64", libs.androidx.room.compiler)
    add("kspIosArm64", libs.androidx.room.compiler)
    //Coil
    implementation(libs.coil.compose)
    implementation(libs.coil.gif)
}

room {
    schemaDirectory("$projectDir/schemas")
}