package com.kmm.moonflower.feature.unsplash.data.repository

import com.kmm.moonflower.feature.unsplash.data.remote.UnsplashRemoteDataSource
import com.kmm.moonflower.feature.unsplash.data.repository.mapper.UnsplashMapper
import com.kmm.moonflower.feature.unsplash.domain.repository.UnsplashRepository
import com.kmm.moonflower.feature.unsplash.domain.vo.UnsplashPhotoList

class UnsplashRepositoryImpl(
    private val remote: UnsplashRemoteDataSource
): UnsplashRepository {

    override suspend fun searchPhotos(
        query: String,
        page: Int,
        perPage: Int,
        clientId: String?
    ): UnsplashPhotoList {
        return UnsplashMapper.toUnsplashPhotoList(
            remote.searchPhotos(
                query = query,
                page = page,
                perPage = perPage,
                clientId = clientId ?: "Bpwa8WCrDj5Ujy-6Wr7gUQm1ZlPa0IO1VJMkjbHOE9Q",
            )
        )
    }
}