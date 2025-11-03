package com.pixaplace

class JsPlatform: Platform {
    override val name: String = "Web with Kotlin/JS"
    override val isMobile = false
    override val isTablet = false
    override val secureStorage = JSSecureStorage()
}

actual val currentPlatform: Platform = JsPlatform()
