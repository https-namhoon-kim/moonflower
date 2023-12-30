package com.kmm.moonflower.feature.unsplash.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class UnsplashPhotoListDto(
    val results: List<UnsplashPhotoDto>,
    val total_pages: Int
)