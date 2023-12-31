package com.kmm.moonflower.feature.unsplash.data.remote

import com.kmm.moonflower.feature.unsplash.data.remote.dto.UnsplashPhotoListDto

interface UnsplashRemoteDataSource {

    suspend fun searchPhotos(
        query: String,
        page: Int,
        perPage: Int,
        clientId: String,
    ): UnsplashPhotoListDto

}