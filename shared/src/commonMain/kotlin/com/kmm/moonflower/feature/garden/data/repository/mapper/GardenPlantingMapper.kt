package com.kmm.moonflower.feature.garden.data.repository.mapper

import com.kmm.moonflower.feature.garden.domain.vo.Garden
import com.kmm.moonflower.feature.garden.domain.vo.PlantAndGardenPlantings
import com.kmm.moonflower.feature.plant.domain.vo.Plant
import database.GardenPlanting
import database.GetPlantedGardens

object GardenPlantingMapper {

    fun toGarden(dao: GardenPlanting?): Garden {
        return if (dao == null) {
            Garden(
                id = -1,
                plantId = "",
                plantDate = -1,
                lastWateringDate = -1,
            )
        } else {
            Garden(
                id = dao.id,
                plantId = dao.plantId,
                plantDate = dao.plantDate,
                lastWateringDate = dao.lastWateringDate,
            )
        }
    }

    fun toPlantAndGardenPlantings(dao: GetPlantedGardens?): PlantAndGardenPlantings {
        return if (dao == null) {
            PlantAndGardenPlantings(
                plant = Plant(
                    plantId = "",
                    name = "",
                    description = "",
                    growZoneNumber = -1,
                    wateringInterval = -1,
                    imageUrl = ""
                ),
                listOf(
                    Garden(
                        id = -1,
                        plantId = "",
                        plantDate = -1,
                        lastWateringDate = -1,
                    )
                )
            )
        } else {
            PlantAndGardenPlantings(
                plant = Plant(
                    plantId = dao.plantId,
                    name = dao.plantName,
                    description = dao.plantDescription,
                    growZoneNumber = dao.plantGrowZoneNumber.toInt(),
                    wateringInterval = dao.plantWateringInterval.toInt(),
                    imageUrl = dao.plantImageUrl
                ),
                listOf(
                    Garden(
                        id = dao.gardenId,
                        plantId = dao.gardenPlantId,
                        plantDate = dao.gardenPlantDate,
                        lastWateringDate = dao.gardenLastWateringDate,
                    )
                )
            )
        }
    }
}