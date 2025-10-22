package com.pixaplace

import android.content.res.Resources
import android.os.Build

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

// androidMain
actual fun isMobile() = true
actual fun isTablet(): Boolean {
    val configuration = Resources.getSystem().configuration
    return configuration.screenWidthDp >= 600
}