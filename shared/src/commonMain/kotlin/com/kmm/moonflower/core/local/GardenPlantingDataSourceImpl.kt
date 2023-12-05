package com.kmm.moonflower.core.local

import com.kmm.moonflower.core.model.database.Garden
import com.kmm.moonflower.database.AppDatabase
import database.AppDatabaseQueries
import database.GardenPlanting

class GardenPlantingDataSourceImpl(
    database: AppDatabase,
) : GardenPlantingDataSource {

    private val query: AppDatabaseQueries = database.appDatabaseQueries

    override suspend fun getGardenPlanting(): List<Garden> =
        query.getGardenPlanting().executeAsList().map { it.toGardenData() }

    override suspend fun isExistPlantInGardenPlanting(plantId: String): Boolean =
        query.isPlanted(plantId).executeAsOne()

    override suspend fun insertGardenPlanting(
        plantId: String,
        plantDate: Int,
        lastWateringDate: Int
    ) {
        query.insertGardenPlanting(
            plantId = plantId,
            plantDate = plantDate.toLong(),
            lastWateringDate = lastWateringDate.toLong()
        )
    }

    override suspend fun deleteGardenPlanting(gardenId: Int) {
        query.deleteGardenPlanting(gardenId.toLong())
    }

    private fun GardenPlanting.toGardenData() = Garden(
        id = this.id.toInt(),
        plantId = this.plantId,
        plantDate = this.plantDate.toInt(),
        lastWateringDate = this.lastWateringDate.toInt()
    )
}