package com.kmm.moonflower.android.viewmodels

import androidx.lifecycle.ViewModel
import com.kmm.moonflower.android.data.GardenPlantingRepository
import com.kmm.moonflower.android.data.PlantAndGardenPlantings
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class GardenPlantingListViewModel @Inject internal constructor(
    gardenPlantingRepository: GardenPlantingRepository
) : ViewModel() {
    val plantAndGardenPlantings: Flow<List<PlantAndGardenPlantings>> =
        gardenPlantingRepository.getPlantedGardens()
}