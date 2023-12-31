package com.kmm.moonflower.feature.unsplash.data.network

import com.kmm.moonflower.feature.unsplash.data.remote.dto.UnsplashPhotoListDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType

class KtorUnsplashClient(
    private val httpClient: HttpClient
) {

    suspend fun searchPhotos(
        query: String,
        page: Int,
        perPage: Int,
        clientId: String,
    ): UnsplashPhotoListDto {
        return httpClient.get(
            "https://api.unsplash.com/search/photos" +
                    "?query=$query" +
                    "&page=$page" +
                    "&per_page=$perPage" +
                    "&client_id=$clientId"
        ) {
            contentType(ContentType.Application.Json)
        }.body<UnsplashPhotoListDto>()
    }
}