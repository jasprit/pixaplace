package com.pixaplace

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.useContents
import platform.UIKit.UIDevice
import platform.UIKit.UIScreen

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()


// iosMain
actual fun isMobile() = true
@OptIn(ExperimentalForeignApi::class)
actual fun isTablet(): Boolean {
    val screenSize = UIScreen.mainScreen.bounds.useContents { size }
    val minDimension = minOf(screenSize.width, screenSize.height)
    return minDimension >= 600.0
}