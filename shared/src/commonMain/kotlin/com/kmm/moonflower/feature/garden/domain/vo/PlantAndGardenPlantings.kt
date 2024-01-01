package com.kmm.moonflower.feature.garden.domain.vo

import com.kmm.moonflower.feature.plant.domain.vo.Plant

data class PlantAndGardenPlantings(
    val plant: Plant,
    val gardenPlantings: List<Garden> = emptyList()
)
