package com.kmm.moonflower.feature.garden.data.repository.mapper

import com.kmm.moonflower.feature.garden.domain.vo.Garden
import database.GardenPlanting

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
}