package com.kmm.moonflower.feature.garden.domain.repository

import com.kmm.moonflower.feature.garden.domain.vo.Garden
import com.kmm.moonflower.feature.garden.domain.vo.PlantAndGardenPlantings

interface GardenPlantingRepository {
    suspend fun getGardenPlanting(): List<Garden>

    suspend fun isExistPlantInGardenPlanting(plantId: String): Boolean

    suspend fun getPlantedGardens(): List<PlantAndGardenPlantings>

    suspend fun insertGardenPlanting(plantId: String, plantDate: Long, lastWateringDate: Long)

    suspend fun deleteGardenPlanting(gardenId : Int)
}