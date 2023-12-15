package com.kmm.moonflower.core.fs.data

import com.kmm.moonflower.core.fs.domain.PlantsFileRepository
import com.kmm.moonflower.core.local.PlantDataSource
import com.kmm.moonflower.core.model.database.Plant
import com.kmm.moonflower.core.resources.FileResourceReader
import kotlinx.serialization.json.Json

class PlantsFileRepositoryImpl(
    private val plantsDataSource: PlantDataSource ,
    private val fileResourceReader: FileResourceReader
) : PlantsFileRepository {

    override suspend fun insertPlantsJson(filePath: String) {
        val platsJson = fileResourceReader.getJsonFileToString(filePath)
        val plants = Json.decodeFromString<List<Plant>>(platsJson)
        plantsDataSource.insertOrReplacePlants(plants)
    }

}