package com.kmm.moonflower.feature.garden.data.local

import com.kmm.moonflower.feature.garden.domain.vo.Garden
import com.kmm.moonflower.feature.garden.domain.vo.PlantAndGardenPlantings

interface GardenPlantingLocalDataSource {

    suspend fun getGardenPlanting(): List<Garden>

    suspend fun isExistPlantInGardenPlanting(plantId: String): Boolean

    suspend fun getPlantedGardens(): List<PlantAndGardenPlantings>

    suspend fun insertGardenPlanting(plantId: String, plantDate: Int, lastWateringDate: Int)

    suspend fun deleteGardenPlanting(gardenId : Int)
}