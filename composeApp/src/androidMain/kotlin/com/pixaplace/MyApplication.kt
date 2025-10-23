package com.pixaplace

import android.app.Application

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize shared KMP library with Android context
        AppContextProvider.context = applicationContext
    }
}