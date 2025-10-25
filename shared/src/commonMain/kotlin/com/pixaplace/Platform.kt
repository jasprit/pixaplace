package com.pixaplace

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform


// commonMain
expect fun isMobile(): Boolean
expect fun isTablet(): Boolean
expect fun createSecureStorage(): SecureStorage