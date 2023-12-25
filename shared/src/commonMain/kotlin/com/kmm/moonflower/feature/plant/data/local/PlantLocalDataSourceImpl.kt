package com.kmm.moonflower.feature.plant.data.local

import com.kmm.moonflower.core.model.database.Plant
import com.kmm.moonflower.feature.plant.data.repository.mapper.PlantMapper

class PlantLocalDataSourceImpl(
    query: AppDatabaseQueries
): PlantLocalDataSource {
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
        return query.getPlants().executeAsList().map { it.toPlantModel() }
    }

    override suspend fun getPlantById(id: String): Plant? {
        return query.getPlant(id).executeAsOneOrNull()?.toPlantModel()
    }

    override suspend fun getPlantsWithGrowZoneNumber(growZoneNumber: Int): List<Plant> {
        return query.getPlantsWithGrowZoneNumber(growZoneNumber.toLong())
            .executeAsList()
            .map { PlantMapper.toPlant(it) }
    }
}