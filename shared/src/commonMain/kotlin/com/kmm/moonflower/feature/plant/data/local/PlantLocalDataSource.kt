package com.kmm.moonflower.feature.plant.data.local

import com.kmm.moonflower.feature.plant.domain.vo.Plant

interface PlantLocalDataSource {
    suspend fun insertOrReplacePlants(plants: List<Plant>)

    suspend fun getAllPlants(): List<Plant>

    suspend fun getPlantById(id: String): Plant

    suspend fun getPlantsWithGrowZoneNumber(growZoneNumber: Int): List<Plant>
}