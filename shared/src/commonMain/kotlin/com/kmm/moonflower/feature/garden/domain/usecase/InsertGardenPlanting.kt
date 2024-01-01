package com.kmm.moonflower.feature.garden.domain.usecase

import com.kmm.moonflower.feature.garden.domain.repository.GardenPlantingRepository

class InsertGardenPlanting(
    private val repository: GardenPlantingRepository
) {
    suspend operator fun invoke(
        plantId: String,
        plantDate: Long,
        lastWateringDate: Long
    ) {
        repository.insertGardenPlanting(
            plantId = plantId,
            plantDate = plantDate,
            lastWateringDate = lastWateringDate,
        )
    }
}