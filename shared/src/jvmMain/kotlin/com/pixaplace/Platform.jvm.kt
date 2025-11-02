package com.pixaplace

import com.pixaplace.platform.Platform
import com.pixaplace.platform.SecureStorage

class JVMPlatform : Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
}

actual fun getPlatform(): Platform = JVMPlatform()

// jsMain (web)
actual fun isMobile() = false
actual fun isTablet() = false
actual fun createSecureStorage(): SecureStorage = JSSecureStorage()