package com.kmm.moonflower.core.fs.domain

interface PlantsFileRepository {

    suspend fun insertPlantsJson(filePath : String)
}