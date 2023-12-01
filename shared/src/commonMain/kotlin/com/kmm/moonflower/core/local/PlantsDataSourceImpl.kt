package com.kmm.moonflower.core.local

import com.example.moonflowerproto.database.AppDatabase
import database.AppDatabaseQueries
import database.Plants
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @param dispatcher 안드로이드 io 디스패처 사용
 */
class PlantsDataSourceImpl(
    private val database: AppDatabase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
) : PlantDataSource {

    private val query : AppDatabaseQueries = database.appDatabaseQueries

    override suspend fun insertOrReplacePlants(plants: List<Plant>) {
        withContext(dispatcher) {
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
    }

    override suspend fun getAllPlants(): List<Plant> = withContext(dispatcher) {
        query.getPlants()
            .executeAsList()
            .map { it.toPlantModel() }
    }

    override suspend fun getPlantById(id: String): Plant? = withContext(dispatcher) {
        query.getPlant(id)
            .executeAsOneOrNull()?.toPlantModel()
    }

    override suspend fun getPlantsWithGrowZoneNumber(growZoneNumber: Int): List<Plant> =
        withContext(dispatcher) {
            query.getPlantsWithGrowZoneNumber(growZoneNumber.toLong())
                .executeAsList()
                .map { it.toPlantModel() }
        }

    private fun Plants.toPlantModel() = Plant(
        plantId = this.id,
        name = this.name,
        description = this.description,
        growZoneNumber = this.growZoneNumber.toInt(),
        wateringInterval = this.wateringInterval.toInt(),
        imageUrl = this.imageUrl
    )
}