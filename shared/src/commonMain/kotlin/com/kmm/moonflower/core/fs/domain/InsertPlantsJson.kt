package com.kmm.moonflower.core.fs.domain

class InsertPlantsJson(
    private val plantsFileRepository: PlantsFileRepository,
) {

    suspend operator fun invoke(filePath: String) {
        plantsFileRepository.insertPlantsJson(filePath)
    }
}