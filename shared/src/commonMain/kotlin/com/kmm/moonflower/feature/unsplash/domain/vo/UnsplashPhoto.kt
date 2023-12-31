package com.kmm.moonflower.feature.unsplash.domain.vo

data class UnsplashPhoto(
    val id: String,
    val urls: UnsplashPhotoUrls,
    val user: UnsplashUser,
)