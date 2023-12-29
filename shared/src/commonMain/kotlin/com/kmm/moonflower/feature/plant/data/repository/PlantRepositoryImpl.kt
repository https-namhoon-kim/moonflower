package com.kmm.moonflower.feature.plant.data.repository

import com.kmm.moonflower.feature.plant.data.local.PlantLocalDataSource
import com.kmm.moonflower.feature.plant.domain.repository.PlantRepository
import com.kmm.moonflower.feature.plant.domain.vo.Plant

class PlantRepositoryImpl(
    private val local: PlantLocalDataSource,
) : PlantRepository {
    override suspend fun insertOrReplacePlants(filePath: String) {
        val plant = local.getPlantsFromResource(filePath)
        local.insertOrReplacePlants(plant)
    }

    override suspend fun getAllPlants(): List<Plant> {
        return local.getAllPlants()
    }

    override suspend fun getPlantById(id: String): Plant {
        return local.getPlantById(id)
    }

    override suspend fun getPlantsWithGrowZoneNumber(growZoneNumber: Int): List<Plant> {
        return local.getPlantsWithGrowZoneNumber(growZoneNumber)
    }
}