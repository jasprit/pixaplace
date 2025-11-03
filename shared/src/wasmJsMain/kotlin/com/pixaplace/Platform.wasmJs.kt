package com.pixaplace


class WasmPlatform : Platform {
    override val name: String = "Web with Kotlin/Wasm"
    override val isMobile = false
    override val isTablet = false
    override val secureStorage = JSSecureStorage()
}

actual val currentPlatform: Platform = WasmPlatform()