package com.kmm.moonflower.feature.unsplash.domain.vo

data class UnsplashUser(
    val name: String,
    val username: String,
) {
    val attributionUrl: String
        get() = "https://unsplash.com/$username?utm_source=sunflower&utm_medium=referral"
}