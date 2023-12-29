package com.kmm.moonflower.feature.garden.domain.usecase

import com.kmm.moonflower.feature.garden.domain.repository.GardenPlantingRepository
import com.kmm.moonflower.feature.garden.domain.vo.Garden

class FetchGardenPlantingList(
    private val repository: GardenPlantingRepository
) {
    suspend operator fun invoke(): List<Garden> {
        return repository.getGardenPlanting()
    }
}