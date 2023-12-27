package com.kmm.moonflower.feature.plant.domain.usecase

import com.kmm.moonflower.feature.plant.domain.repository.PlantRepository
import com.kmm.moonflower.feature.plant.domain.vo.Plant

class GetPlantListWithGrowZoneNumber(
    private val repository: PlantRepository,
) {

    suspend operator fun invoke(growZoneNumber: Int): List<Plant> {
        return repository.getPlantsWithGrowZoneNumber(
            growZoneNumber = growZoneNumber,
        )
    }
}