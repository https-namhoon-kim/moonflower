package com.kmm.moonflower.feature.unsplash.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class UnsplashPhotoDto(
    val id: String,
    val urls: UnsplashPhotoUrlsDto,
    val user: UnsplashUserDto,
)