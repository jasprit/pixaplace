package com.pixaplace

class JsPlatform : Platform {
    override val name: String = "Web with Kotlin/JS"
}

actual fun getPlatform(): Platform = JsPlatform()


// jsMain (web)
actual fun isMobile() = false
actual fun isTablet() = false
actual fun createSecureStorage(): SecureStorage = JSSecureStorage()