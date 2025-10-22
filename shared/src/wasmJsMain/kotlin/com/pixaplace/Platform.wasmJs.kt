package com.pixaplace

class WasmPlatform: Platform {
    override val name: String = "Web with Kotlin/Wasm"
}

actual fun getPlatform(): Platform = WasmPlatform()

// jsMain (web)
actual fun isMobile() = false
actual fun isTablet() = false