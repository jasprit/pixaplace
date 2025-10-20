package com.pixaplace

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform