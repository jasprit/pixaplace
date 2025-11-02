package com.pixaplace

import com.pixaplace.platform.Platform
import com.pixaplace.platform.SecureStorage

class WasmPlatform : Platform {
    override val name: String = "Web with Kotlin/Wasm"
}

actual fun getPlatform(): Platform = WasmPlatform()

// jsMain (web)
actual fun isMobile() = false
actual fun isTablet() = false
actual fun createSecureStorage(): SecureStorage = JSSecureStorage()