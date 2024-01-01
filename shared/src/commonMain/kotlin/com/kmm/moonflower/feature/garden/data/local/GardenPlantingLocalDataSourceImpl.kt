package com.kmm.moonflower.feature.garden.data.local

import com.kmm.moonflower.database.AppDatabase
import com.kmm.moonflower.feature.garden.data.repository.mapper.GardenPlantingMapper
import com.kmm.moonflower.feature.garden.domain.vo.Garden
import database.AppDatabaseQueries


class GardenPlantingLocalDataSourceImpl(
    database: AppDatabase,
): GardenPlantingLocalDataSource {

    private val query: AppDatabaseQueries = database.appDatabaseQueries

    override suspend fun getGardenPlanting(): List<Garden> {
        return query.getGardenPlanting().executeAsList().map { GardenPlantingMapper.toGarden(it) }
    }

    override suspend fun isExistPlantInGardenPlanting(plantId: String): Boolean {
        return query.isPlanted(plantId).executeAsOne()
    }

    override suspend fun insertGardenPlanting(
        plantId: String,
        plantDate: Long,
        lastWateringDate: Long
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
}
