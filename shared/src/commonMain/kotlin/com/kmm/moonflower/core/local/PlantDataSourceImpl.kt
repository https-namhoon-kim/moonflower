package com.kmm.moonflower.core.local

import com.example.moonflowerproto.database.AppDatabase
import database.AppDatabaseQueries
import database.Plants

class PlantDataSourceImpl(
    private val database: AppDatabase,
) : PlantDataSource {

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

    override suspend fun getAllPlants(): List<Plant> =
        query.getPlants().executeAsList().map { it.toPlantModel() }

    override suspend fun getPlantById(id: String): Plant? =
        query.getPlant(id).executeAsOneOrNull()?.toPlantModel()

    override suspend fun getPlantsWithGrowZoneNumber(growZoneNumber: Int): List<Plant> =
        query.getPlantsWithGrowZoneNumber(growZoneNumber.toLong())
            .executeAsList()
            .map { it.toPlantModel() }

    private fun Plants.toPlantModel() = Plant(
        plantId = this.id,
        name = this.name,
        description = this.description,
        growZoneNumber = this.growZoneNumber.toInt(),
        wateringInterval = this.wateringInterval.toInt(),
        imageUrl = this.imageUrl
    )
}