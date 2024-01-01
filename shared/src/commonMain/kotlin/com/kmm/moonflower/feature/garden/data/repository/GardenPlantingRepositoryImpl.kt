package com.kmm.moonflower.feature.garden.data.repository

import com.kmm.moonflower.feature.garden.data.local.GardenPlantingLocalDataSource
import com.kmm.moonflower.feature.garden.domain.repository.GardenPlantingRepository
import com.kmm.moonflower.feature.garden.domain.vo.Garden

class GardenPlantingRepositoryImpl(
    private val local: GardenPlantingLocalDataSource,
): GardenPlantingRepository {
    override suspend fun getGardenPlanting(): List<Garden> {
        return local.getGardenPlanting()
    }

    override suspend fun isExistPlantInGardenPlanting(plantId: String): Boolean {
        return local.isExistPlantInGardenPlanting(plantId)
    }

    override suspend fun insertGardenPlanting(
        plantId: String,
        plantDate: Long,
        lastWateringDate: Long
    ) {
        local.insertGardenPlanting(
            plantId = plantId,
            plantDate = plantDate,
            lastWateringDate = lastWateringDate,
        )
    }

    override suspend fun deleteGardenPlanting(gardenId: Int) {
        local.deleteGardenPlanting(gardenId)
    }
}