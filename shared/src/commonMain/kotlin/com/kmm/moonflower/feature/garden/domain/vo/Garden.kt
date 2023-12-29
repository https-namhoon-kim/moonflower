package com.kmm.moonflower.feature.garden.domain.vo

data class Garden(
    val id: Long,
    val plantId: String,
    val plantDate: Long,
    val lastWateringDate: Long,
)