package com.kmm.moonflower.di

import com.kmm.moonflower.core.local.DatabaseDriverFactory
import com.kmm.moonflower.database.AppDatabase
import com.kmm.moonflower.feature.garden.data.local.GardenPlantingLocalDataSourceImpl
import com.kmm.moonflower.feature.garden.data.repository.GardenPlantingRepositoryImpl
import com.kmm.moonflower.feature.garden.domain.repository.GardenPlantingRepository

object GardenPlantingFeatureModule {

    fun provideGardenPlantingRepository(): GardenPlantingRepository {
        return GardenPlantingRepositoryImpl(
            local = GardenPlantingLocalDataSourceImpl(
                database = AppDatabase(DatabaseDriverFactory().createDriver())
            )
        )
    }
}