package com.kmm.moonflower.android.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.kmm.moonflower.android.data.UnsplashPagingSource
import com.kmm.moonflower.feature.unsplash.domain.vo.UnsplashPhoto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private var queryString: String? = savedStateHandle["plantName"]

    val plantPictures = getPagingDataStream(queryString ?: "")
//        repository.getSearchResultStream(queryString ?: "").cachedIn(viewModelScope)

    private val NETWORK_PAGE_SIZE = 25

    private fun getPagingDataStream(query: String): Flow<PagingData<UnsplashPhoto>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = NETWORK_PAGE_SIZE),
            pagingSourceFactory = { UnsplashPagingSource(query) }
        ).flow
    }
}