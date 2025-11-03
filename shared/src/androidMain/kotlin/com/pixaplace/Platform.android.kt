package com.pixaplace

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import com.pixaplace.storage.AndroidSecureStorage
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AndroidPlatform : Platform, KoinComponent {
    private val context: Context by inject()

    override val name: String = "Android ${Build.VERSION.SDK_INT}"
    override val isMobile = true
    override val isTablet: Boolean
        get() {
            val config = context.resources.configuration
            return config.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK >= Configuration.SCREENLAYOUT_SIZE_LARGE
        }
    override val secureStorage = AndroidSecureStorage()
}

actual val currentPlatform: Platform = AndroidPlatform()
