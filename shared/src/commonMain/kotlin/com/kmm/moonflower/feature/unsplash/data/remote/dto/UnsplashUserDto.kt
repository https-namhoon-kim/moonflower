package com.kmm.moonflower.feature.unsplash.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class UnsplashUserDto(
    val name: String,
    val username: String,
)
