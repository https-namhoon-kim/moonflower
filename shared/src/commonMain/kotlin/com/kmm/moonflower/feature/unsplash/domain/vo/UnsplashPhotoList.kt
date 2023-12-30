package com.kmm.moonflower.feature.unsplash.domain.vo

data class UnsplashPhotoList(
    val results: List<UnsplashPhoto>,
    val totalPages: Int
)