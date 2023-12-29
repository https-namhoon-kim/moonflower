package com.kmm.moonflower.feature.plant.domain.usecase

import com.kmm.moonflower.feature.plant.domain.repository.PlantRepository

class InsertOrReplacePlants(
    private val repository: PlantRepository,
) {

    suspend operator fun invoke(filePath : String = "json/plants.json") {
        repository.insertOrReplacePlants(
            filePath = filePath
        )
    }
}