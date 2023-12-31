package com.kmm.moonflower.di

import android.content.Context
import com.kmm.moonflower.core.local.DatabaseDriverFactory
import com.kmm.moonflower.core.resources.FileResourceReaderWithCompose
import com.kmm.moonflower.database.AppDatabase
import com.kmm.moonflower.feature.plant.data.local.PlantLocalDataSourceImpl
import com.kmm.moonflower.feature.plant.data.repository.PlantRepositoryImpl
import com.kmm.moonflower.feature.plant.domain.repository.PlantRepository

object PlantFeatureModule {

    private var database: AppDatabase? = null

    fun init(context: Context) {
        val sqlDriver = DatabaseDriverFactory(context).createDriver()
        database = AppDatabase(sqlDriver)
    }

    fun providePlantRepository(): PlantRepository {
        database?.let {
            return PlantRepositoryImpl(
                local = PlantLocalDataSourceImpl(
                    database = it,
                    resource = FileResourceReaderWithCompose(),
                )
            )
        } ?: throw Exception("Database not initialized.")
    }

}