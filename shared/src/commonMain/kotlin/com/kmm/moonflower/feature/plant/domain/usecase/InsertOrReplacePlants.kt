package com.kmm.moonflower.feature.plant.domain.usecase

import com.kmm.moonflower.feature.plant.domain.repository.PlantRepository
import com.kmm.moonflower.feature.plant.domain.vo.Plant

class InsertOrReplacePlants(
    private val repository: PlantRepository,
) {

    suspend operator fun invoke(plants: List<Plant>) {
        repository.insertOrReplacePlants(
            plants = plants,
        )
    }
}