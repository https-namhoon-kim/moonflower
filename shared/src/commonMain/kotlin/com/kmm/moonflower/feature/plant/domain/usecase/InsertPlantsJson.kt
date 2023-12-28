package com.kmm.moonflower.feature.plant.domain.usecase

import com.kmm.moonflower.core.resources.FileResourceReader
import com.kmm.moonflower.feature.plant.domain.vo.Plant
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class InsertPlantsJson(
    private val fileResourceReader: FileResourceReader,
    private val insertOrReplacePlants: InsertOrReplacePlants,
) {

    suspend operator fun invoke() {
        val platsJson = fileResourceReader.getJsonFileToString(PLANTS_JSON_PATH)
        val plants = Json.decodeFromString<List<Plant>>(platsJson)
        insertOrReplacePlants.invoke(plants)
    }

    companion object {
        const val PLANTS_JSON_PATH = "json/plants.json"
    }
}