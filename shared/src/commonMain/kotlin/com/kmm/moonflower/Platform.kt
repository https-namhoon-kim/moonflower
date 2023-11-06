package com.kmm.moonflower

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform