import org.gradle.api.JavaVersion

object Config {
    const val appId = "com.feliperrm.mathem"
    const val minSdk = 24
    const val targetSdk = 33
    const val versionCode = 999999
    const val versionName = "1.0"
    val javaVersion = JavaVersion.VERSION_17
    const val jvmTarget = "17"
    const val kotlinCompilerExtensionVersion = "1.4.7"
}
