package com.kmm.moonflower.feature.plant.domain.repository

import com.kmm.moonflower.feature.plant.domain.vo.Plant

interface PlantRepository {
    suspend fun insertOrReplacePlants(plants: List<Plant>)

    suspend fun getAllPlants(): List<Plant>

    suspend fun getPlantById(id: String): Plant

    suspend fun getPlantsWithGrowZoneNumber(growZoneNumber: Int): List<Plant>
}