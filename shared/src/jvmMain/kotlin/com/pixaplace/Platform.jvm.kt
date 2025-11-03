package com.pixaplace


class JVMPlatform : Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
    override val isMobile = false
    override val isTablet = false
    override val secureStorage = JSSecureStorage()
}

actual val currentPlatform: Platform = JVMPlatform()