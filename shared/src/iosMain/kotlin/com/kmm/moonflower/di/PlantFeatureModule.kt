package com.kmm.moonflower.di

import com.kmm.moonflower.core.local.DatabaseDriverFactory
import com.kmm.moonflower.core.resources.FileResourceReaderPlatform
import com.kmm.moonflower.database.AppDatabase
import com.kmm.moonflower.feature.plant.data.local.PlantLocalDataSourceImpl
import com.kmm.moonflower.feature.plant.data.repository.PlantRepositoryImpl
import com.kmm.moonflower.feature.plant.domain.repository.PlantRepository

object PlantFeatureModule {

    fun providePlantRepository(): PlantRepository {
        return PlantRepositoryImpl(
            local = PlantLocalDataSourceImpl(
                database = AppDatabase(DatabaseDriverFactory().createDriver()),
                resource = FileResourceReaderPlatform(),
            )
        )
    }

}