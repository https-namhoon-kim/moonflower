package com.kmm.moonflower.di

import android.content.Context
import com.kmm.moonflower.core.local.DatabaseDriverFactory
import com.kmm.moonflower.database.AppDatabase
import com.kmm.moonflower.feature.garden.data.local.GardenPlantingLocalDataSourceImpl
import com.kmm.moonflower.feature.garden.data.repository.GardenPlantingRepositoryImpl
import com.kmm.moonflower.feature.garden.domain.repository.GardenPlantingRepository

object GardenPlantingFeatureModule {

    private var database: AppDatabase? = null

    fun init(context: Context) {
        val sqlDriver = DatabaseDriverFactory(context).createDriver()
        database = AppDatabase(sqlDriver)
    }

    fun provideGardenPlantingRepository(): GardenPlantingRepository {
        database?.let {
            return GardenPlantingRepositoryImpl(
                local = GardenPlantingLocalDataSourceImpl(
                    database = it
                )
            )
        } ?: throw Exception("Database not initialized.")
    }
}