package com.kmm.moonflower.di

import com.kmm.moonflower.feature.garden.data.local.GardenPlantingLocalDataSource
import com.kmm.moonflower.feature.garden.data.local.GardenPlantingLocalDataSourceImpl
import com.kmm.moonflower.feature.garden.data.repository.GardenPlantingRepositoryImpl
import com.kmm.moonflower.feature.garden.domain.repository.GardenPlantingRepository
import com.kmm.moonflower.feature.garden.domain.usecase.FetchGardenPlantingList
import com.kmm.moonflower.feature.garden.domain.usecase.RemoveGardenPlanting

object GardenFeatureModule {

    private fun provideGardenPlantingLocalDataSource(): GardenPlantingLocalDataSource {
        return GardenPlantingLocalDataSourceImpl(
            database = DatabaseModule.provideAppDatabase()
        )
    }

    private fun provideGardenPlantingRepository(): GardenPlantingRepository {
        return GardenPlantingRepositoryImpl(
            local = provideGardenPlantingLocalDataSource()
        )
    }

    fun provideFetchGardenPlantingList() : FetchGardenPlantingList {
        return FetchGardenPlantingList(
            repository = provideGardenPlantingRepository()
        )
    }

    fun provideRemoveGardenPlanting() : RemoveGardenPlanting {
        return RemoveGardenPlanting(
            repository = provideGardenPlantingRepository()
        )
    }

}