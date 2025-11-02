package com.pixaplace

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import com.pixaplace.platform.Platform
import com.pixaplace.platform.SecureStorage
import com.pixaplace.storage.AndroidSecureStorage
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


actual fun getPlatform(): Platform = AndroidPlatform()

class AndroidPlatform : Platform, KoinComponent {

    private val context: Context by inject()

    override val name: String = "Android ${Build.VERSION.SDK_INT}"
    override val isMobile = true
    override val isTablet: Boolean
        get() {
            val config = context.resources.configuration
            return config.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK >= Configuration.SCREENLAYOUT_SIZE_LARGE
        }
}



//// Provide your App Context via singleton or DI
//// TODO: Static reference: Needs to remove this
//object AppContextProvider {
//    lateinit var context: Context
//}

// Actual function resolving Android storage
actual fun createSecureStorage(): SecureStorage {
    return AndroidSecureStorage(AppContextProvider.context)
}