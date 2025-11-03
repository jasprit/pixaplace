package com.pixaplace

import com.pixaplace.storage.IOSSecureStorage
import platform.UIKit.UIDevice
import platform.UIKit.UIUserInterfaceIdiomPad

class IOSPlatform : Platform {
    override val name: String = "iOS"
    override val isMobile = true
    override val isTablet = UIDevice.currentDevice.userInterfaceIdiom == UIUserInterfaceIdiomPad
    override val secureStorage = IOSSecureStorage()
}

actual val currentPlatform: Platform = IOSPlatform()