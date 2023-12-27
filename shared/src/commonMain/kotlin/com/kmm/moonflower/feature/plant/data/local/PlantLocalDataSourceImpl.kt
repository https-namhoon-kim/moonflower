package com.kmm.moonflower.feature.plant.data.local

import com.kmm.moonflower.feature.plant.data.repository.mapper.PlantMapper
import com.kmm.moonflower.feature.plant.domain.vo.Plant
import com.kmm.moonflower.database.AppDatabase
import database.AppDatabaseQueries

class PlantLocalDataSourceImpl(
    database: AppDatabase,
): PlantLocalDataSource {

    private val query: AppDatabaseQueries = database.appDatabaseQueries

    override suspend fun insertOrReplacePlants(plants: List<Plant>) {
        query.run {
            transaction {
                plants.forEach { plant ->
                    insertPlantsAll(
                        id = plant.plantId,
                        name = plant.name,
                        description = plant.description,
                        growZoneNumber = plant.growZoneNumber.toLong(),
                        wateringInterval = plant.growZoneNumber.toLong(),
                        imageUrl = plant.imageUrl
                    )
                }
            }
        }
    }

    override suspend fun getAllPlants(): List<Plant> {
        return query.getPlants().executeAsList().map {
            PlantMapper.toPlant(it)
        }
    }

    override suspend fun getPlantById(id: String): Plant? {
        val plants = query.getPlant(id).executeAsOneOrNull() ?: return null
        return PlantMapper.toPlant(plants)
    }

    override suspend fun getPlantsWithGrowZoneNumber(growZoneNumber: Int): List<Plant> {
        return query.getPlantsWithGrowZoneNumber(growZoneNumber.toLong())
            .executeAsList()
            .map { PlantMapper.toPlant(it) }
    }
}