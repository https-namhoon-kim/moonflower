package com.kmm.moonflower.feature.unsplash.data.remote

import com.kmm.moonflower.feature.unsplash.data.network.KtorUnsplashClient
import com.kmm.moonflower.feature.unsplash.data.remote.dto.UnsplashPhotoListDto

class UnsplashRemoteDataSourceImpl(
    private val api: KtorUnsplashClient
): UnsplashRemoteDataSource {

    override suspend fun searchPhotos(
        query: String,
        page: Int,
        perPage: Int,
        clientId: String,
    ): UnsplashPhotoListDto {
        return api.searchPhotos(
            query = query,
            page = page,
            perPage = perPage,
            clientId = clientId,
        )
    }
}