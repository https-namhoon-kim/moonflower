package com.kmm.moonflower.feature.garden.domain.usecase

import com.kmm.moonflower.feature.garden.domain.repository.GardenPlantingRepository
import com.kmm.moonflower.feature.garden.domain.vo.PlantAndGardenPlantings


class FetchPlantedGardenList(
    private val repository: GardenPlantingRepository
) {
    suspend operator fun invoke(): List<PlantAndGardenPlantings> {
        return repository.getPlantedGardens()
    }
}