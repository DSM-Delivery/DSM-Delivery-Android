import org.gradle.api.JavaVersion

object ProjectProperties {
    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0"

    const val APPLICATION_ID = "dsm.delivery"

    const val GRADLE_ANDROID = "7.2.1"
    const val GRADLE_KOTLIN = "1.6.10"

    val JAVA_VERSION = JavaVersion.VERSION_11
    const val KOTLIN_VERSION = "1.8.10"
    const val KOTLINX_COROUTINES = "1.6.0"

    const val BUILD_GRADLE = "4.2.1"
    const val COMPILE_SDK_VERSION = 33
    const val BUILD_TOOLS_VERSION = "33.0.0"
    const val MIN_SDK_VERSION = 30
    const val TARGET_SDK_VERSION = 33
}