package com.kmm.moonflower.feature.garden.domain.usecase

import com.kmm.moonflower.feature.garden.domain.repository.GardenPlantingRepository

class RemoveGardenPlanting(
    private val repository: GardenPlantingRepository
) {
    suspend operator fun invoke(gardenId: Int) {
        repository.deleteGardenPlanting(
            gardenId = gardenId,
        )
    }
}