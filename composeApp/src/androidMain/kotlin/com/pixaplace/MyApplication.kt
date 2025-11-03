package com.pixaplace

import android.app.Application
import org.koin.core.context.startKoin
import org.koin.android.ext.koin.androidContext

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Start Koin + inject Context
        startKoin {
            androidContext(this@MyApplication)
        }

        // Initialize with platform
        //   KoinInitializer.start(currentPlatform)*/
    }
}