package com.kmm.moonflower.feature.plant.domain.vo

import kotlinx.serialization.Serializable

@Serializable
data class Plant(
    val plantId: String,
    val name: String,
    val description: String,
    val growZoneNumber: Int,
    val wateringInterval: Int,
    val imageUrl: String,
)
