package com.kmm.moonflower.feature.garden.domain.repository

import com.kmm.moonflower.feature.garden.domain.vo.Garden

interface GardenPlantingRepository {
    suspend fun getGardenPlanting(): List<Garden>

    suspend fun isExistPlantInGardenPlanting(plantId: String): Boolean

    suspend fun insertGardenPlanting(plantId: String, plantDate: Long, lastWateringDate: Long)

    suspend fun deleteGardenPlanting(gardenId : Int)
}