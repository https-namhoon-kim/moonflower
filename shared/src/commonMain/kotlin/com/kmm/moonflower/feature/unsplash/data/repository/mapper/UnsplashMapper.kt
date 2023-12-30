package com.kmm.moonflower.feature.unsplash.data.repository.mapper

import com.kmm.moonflower.feature.unsplash.data.remote.dto.UnsplashPhotoDto
import com.kmm.moonflower.feature.unsplash.data.remote.dto.UnsplashPhotoListDto
import com.kmm.moonflower.feature.unsplash.data.remote.dto.UnsplashPhotoUrlsDto
import com.kmm.moonflower.feature.unsplash.data.remote.dto.UnsplashUserDto
import com.kmm.moonflower.feature.unsplash.domain.vo.UnsplashPhoto
import com.kmm.moonflower.feature.unsplash.domain.vo.UnsplashPhotoList
import com.kmm.moonflower.feature.unsplash.domain.vo.UnsplashPhotoUrls
import com.kmm.moonflower.feature.unsplash.domain.vo.UnsplashUser

object UnsplashMapper {

    fun toUnsplashPhotoList(dto: UnsplashPhotoListDto?): UnsplashPhotoList {
        return if (dto == null) {
            UnsplashPhotoList(
                results = emptyList(),
                totalPages = -1,
            )
        } else {
            UnsplashPhotoList(
                results = toUnsplashPhoto(dto.results),
                totalPages = dto.total_pages,
            )
        }
    }

    private fun toUnsplashPhoto(dtoList: List<UnsplashPhotoDto>?): List<UnsplashPhoto> {
        if (dtoList == null) {
            return emptyList()
        }

        val unsplashPhotoList = mutableListOf<UnsplashPhoto>()
        dtoList.forEach {
            val unsplashPhoto = UnsplashPhoto(
                id = it.id,
                urls = toUnsplashPhotoUrls(it.urls),
                user = toUnsplashUser(it.user),
            )
            unsplashPhotoList.add(unsplashPhoto)
        }
        return unsplashPhotoList
    }

    private fun toUnsplashPhotoUrls(dto: UnsplashPhotoUrlsDto?): UnsplashPhotoUrls {
        return if (dto == null) {
            UnsplashPhotoUrls(
                small = "",
            )
        } else {
            UnsplashPhotoUrls(
                small = dto.small
            )
        }
    }

    private fun toUnsplashUser(dto: UnsplashUserDto?): UnsplashUser {
        return if (dto == null) {
            UnsplashUser(
                name = "",
                username = "",
            )
        } else {
            UnsplashUser(
                name = dto.name,
                username = dto.username,
            )
        }
    }
}