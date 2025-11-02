package di

import org.koin.core.module.Module

expect object PlatformDi {
    val modules: List<Module>
    fun init()
}