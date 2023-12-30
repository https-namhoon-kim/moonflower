package com.kmm.moonflower.feature.unsplash.domain.repository

import com.kmm.moonflower.feature.unsplash.domain.vo.UnsplashPhotoList

interface UnsplashRepository {

    suspend fun searchPhotos(
        query: String,
        page: Int,
        perPage: Int,
        clientId: String?,
    ): UnsplashPhotoList

}