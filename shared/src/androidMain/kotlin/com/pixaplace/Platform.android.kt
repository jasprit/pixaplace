package com.pixaplace

import android.content.Context
import android.content.res.Resources
import android.os.Build
import com.pixaplace.storage.AndroidSecureStorage

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


// Provide your App Context via singleton or DI
// TODO: Static reference: Needs to remove this
object AppContextProvider {
    lateinit var context: Context
}

// Actual function resolving Android storage
actual fun createSecureStorage(): SecureStorage {
    return AndroidSecureStorage(AppContextProvider.context)
}