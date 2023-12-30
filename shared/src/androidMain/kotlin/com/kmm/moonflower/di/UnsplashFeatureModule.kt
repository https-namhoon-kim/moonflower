package com.kmm.moonflower.di

import com.kmm.moonflower.core.api.HttpClientFactory
import com.kmm.moonflower.feature.unsplash.data.network.KtorUnsplashClient
import com.kmm.moonflower.feature.unsplash.data.remote.UnsplashRemoteDataSourceImpl
import com.kmm.moonflower.feature.unsplash.data.repository.UnsplashRepositoryImpl
import com.kmm.moonflower.feature.unsplash.domain.repository.UnsplashRepository

object UnsplashFeatureModule {

    fun providerUnsplashRepository(): UnsplashRepository {
        return UnsplashRepositoryImpl (
            UnsplashRemoteDataSourceImpl(
                KtorUnsplashClient(
                    HttpClientFactory().create()
                )
            )
        )
    }
}