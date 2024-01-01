/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kmm.moonflower.android.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kmm.moonflower.di.GardenPlantingFeatureModule
import com.kmm.moonflower.di.PlantFeatureModule
import com.kmm.moonflower.feature.garden.domain.repository.GardenPlantingRepository
import com.kmm.moonflower.feature.plant.domain.repository.PlantRepository
import com.kmm.moonflower.feature.plant.domain.vo.Plant
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * The ViewModel used in [PlantDetailFragment].
 */
class PlantDetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val plantRepository: PlantRepository,
    private val gardenPlantingRepository: GardenPlantingRepository
) : ViewModel() {

    val plantId: String = savedStateHandle.get<String>(PLANT_ID_SAVED_STATE_KEY)!!

    private val _isPlanted = MutableLiveData(false)
    val isPlanted: LiveData<Boolean>
        get() = _isPlanted

    private val _plant = MutableLiveData(Plant(plantId, "", "", -1, -1, ""))
    val plant: LiveData<Plant>
        get() = _plant

    private val _showSnackbar = MutableLiveData(false)
    val showSnackbar: LiveData<Boolean>
        get() = _showSnackbar

    init {
        viewModelScope.launch {
            _plant.value = plantRepository.getPlantById(plantId)
            checkIsPlants()
        }
    }

    fun addPlantToGarden() {
        viewModelScope.launch {
            val time = System.currentTimeMillis()
            gardenPlantingRepository.insertGardenPlanting(
                plantId = plantId,
                plantDate = time,
                lastWateringDate = time,
            )
            _showSnackbar.value = true
            checkIsPlants()
        }
    }

    private suspend fun checkIsPlants(){
        _isPlanted.value = gardenPlantingRepository.isExistPlantInGardenPlanting(plantId)
    }

    fun dismissSnackbar() {
        _showSnackbar.value = false
    }

    fun hasValidUnsplashKey() = true

    companion object {
        private const val PLANT_ID_SAVED_STATE_KEY = "plantId"
    }
}

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            FeatherAndroidTasksTheme {
//                // Create an instance of the ViewModel using viewModel function
//                val viewModel: MyViewModel = remember {
//                    viewModel(factory = MyViewModelFactory(savedStateHandle = savedStateHandle))
//                }
//
//                // Use the viewModel in your Compose UI
//                Greeting(name = viewModel.name)
//
//                // Other Compose components...
//            }
//        }
//    }
//}
//
//// ViewModel class with SavedStateHandle
//class MyViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
//    // Example property in the ViewModel
//    var name by savedStateHandle.supportedValue("name_key", "DefaultName")
//        private set
//}