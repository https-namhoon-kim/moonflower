package com.kmm.moonflower.core.local

interface GardenPlantingDataSource {

    suspend fun getGardenPlanting(): List<Garden>

    suspend fun isExistPlantInGardenPlanting(plantId: String): Boolean

    suspend fun insertGardenPlanting(plantId: String, plantDate: Int, lastWateringDate: Int)

    suspend fun deleteGardenPlanting(gardenId : Int)
}