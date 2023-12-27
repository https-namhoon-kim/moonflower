package com.kmm.moonflower.feature.plant.domain.usecase

import com.kmm.moonflower.feature.plant.domain.repository.PlantRepository
import com.kmm.moonflower.feature.plant.domain.vo.Plant

class GetPlantById(
    private val repository: PlantRepository,
) {

    suspend operator fun invoke(id: String): Plant {
        return repository.getPlantById(
            id = id,
        )
    }
}