package com.pixaplace.di


import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

object AppModules {
    val all = listOf(
        coreModule
    ) + PlatformDi.modules

    private val coreModule = module {}
}