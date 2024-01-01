package com.kmm.moonflower.android.compose.utils

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.kmm.moonflower.android.viewmodels.PlantDetailViewModel
import com.kmm.moonflower.di.GardenPlantingFeatureModule
import com.kmm.moonflower.di.PlantFeatureModule

/**
 *  힐트뷰모델을 사용하지 않는 경우 navigation arguments를 viewmodel의 SaveStateHandle에 주입하기 위해 factory를 생성하기 위해 사용
 */
fun getSavedStateViewModelProviderForPlantDetail(
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle?,
) = object : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        if (modelClass.isAssignableFrom(PlantDetailViewModel::class.java)) {
            return PlantDetailViewModel(
                savedStateHandle = handle,
                plantRepository = PlantFeatureModule.providePlantRepository(),
                gardenPlantingRepository = GardenPlantingFeatureModule.provideGardenPlantingRepository()
            ) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}