package com.kmm.moonflower.core.local

interface PlantDataSource {
    suspend fun insertOrReplacePlants(plants: List<Plant>)
    suspend fun getAllPlants(): List<Plant>
    suspend fun getPlantById(id: String): Plant?
    suspend fun getPlantsWithGrowZoneNumber(growZoneNumber: Int): List<Plant>
}