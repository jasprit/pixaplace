package com.pixaplace

import com.pixaplace.storage.SecureStorage

expect val currentPlatform: Platform

interface Platform {
    val name: String
    val isMobile: Boolean
    val isTablet: Boolean

    val secureStorage: SecureStorage
}