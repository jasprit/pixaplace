package com.pixaplace.di


import com.pixaplace.Platform
import org.koin.core.context.startKoin
import org.koin.dsl.module
object KoinInitializer {

    fun start(platform: Platform) {

        startKoin {
            modules(
                appModule(platform)
            )
        }
    }
}

fun appModule(platform: Platform) = module {
    single { platform }
    single { platform.secureStorage }
}