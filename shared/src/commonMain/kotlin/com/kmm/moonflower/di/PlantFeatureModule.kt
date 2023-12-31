package com.kmm.moonflower.di

import com.kmm.moonflower.core.resources.FileResourceReaderWithCompose
import com.kmm.moonflower.feature.plant.data.local.PlantLocalDataSource
import com.kmm.moonflower.feature.plant.data.local.PlantLocalDataSourceImpl
import com.kmm.moonflower.feature.plant.data.repository.PlantRepositoryImpl
import com.kmm.moonflower.feature.plant.domain.repository.PlantRepository
import com.kmm.moonflower.feature.plant.domain.usecase.FetchPlantList
import com.kmm.moonflower.feature.plant.domain.usecase.GetPlantById
import com.kmm.moonflower.feature.plant.domain.usecase.GetPlantListWithGrowZoneNumber
import com.kmm.moonflower.feature.plant.domain.usecase.InsertOrReplacePlants

object PlantFeatureModule {

    private fun providePlantLocalDataSource() : PlantLocalDataSource {
        return PlantLocalDataSourceImpl(
            database = DatabaseModule.provideAppDatabase(),
            resource = FileResourceReaderWithCompose()
        )
    }

    private fun providePlantRepository(): PlantRepository {
        return PlantRepositoryImpl(
            local = providePlantLocalDataSource()
        )
    }

    fun provideFetchPlantList(): FetchPlantList {
        return FetchPlantList(
            repository = providePlantRepository()
        )
    }

    fun provideGetPlantById(): GetPlantById {
        return GetPlantById(
            repository = providePlantRepository()
        )
    }

    fun provideGetPlantListWithGrowZoneNumber(): GetPlantListWithGrowZoneNumber {
        return GetPlantListWithGrowZoneNumber(
            repository = providePlantRepository()
        )
    }

    fun provideInsertOrReplacePlants(): InsertOrReplacePlants {
        return InsertOrReplacePlants(
            repository = providePlantRepository()
        )
    }

}