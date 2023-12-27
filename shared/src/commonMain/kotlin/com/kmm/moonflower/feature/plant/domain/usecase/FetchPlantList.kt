package com.kmm.moonflower.feature.plant.domain.usecase

import com.kmm.moonflower.feature.plant.domain.repository.PlantRepository
import com.kmm.moonflower.feature.plant.domain.vo.Plant

class FetchPlantList(
    private val repository: PlantRepository,
) {

    suspend operator fun invoke(): List<Plant> {
        return repository.getAllPlants()
    }
}