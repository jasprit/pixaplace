package com.pixaplace.platform



interface Platform {
    val name: String
    val isMobile: Boolean
    val isTablet: Boolean

    val secureStorage: SecureStorage
}

expect fun getPlatform(): Platform