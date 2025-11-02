package com.pixaplace.di


import org.koin.core.context.startKoin

object Di {
    fun init() {
        startKoin {
            modules(AppModules.all)
        }
      //  PlatformDi.init()
    }
}