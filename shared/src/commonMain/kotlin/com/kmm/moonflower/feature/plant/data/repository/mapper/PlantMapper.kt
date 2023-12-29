package com.kmm.moonflower.feature.plant.data.repository.mapper

import com.kmm.moonflower.feature.plant.domain.vo.Plant
import database.Plants

object PlantMapper {
    fun toPlant(dao: Plants?): Plant {
        if (dao == null) {
            return Plant(
                plantId = "",
                name = "",
                description = "",
                growZoneNumber = -1,
                wateringInterval = 7,
                imageUrl = "",
            )
        } else {
            return Plant(
                plantId = dao.id,
                name = dao.name,
                description = dao.description,
                growZoneNumber = dao.growZoneNumber.toInt(),
                wateringInterval = dao.wateringInterval.toInt(),
                imageUrl = dao.imageUrl
            )
        }

    }
}