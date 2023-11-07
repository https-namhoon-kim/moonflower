package com.kmm.moonflower.android.data

import com.google.gson.annotations.SerializedName
import com.kmm.moonflower.android.data.UnsplashPhoto

/**
 * Data class that represents a photo search response from Unsplash.
 *
 * Not all of the fields returned from the API are represented here; only the ones used in this
 * project are listed below. For a full list of fields, consult the API documentation
 * [here](https://unsplash.com/documentation#search-photos).
 */
data class UnsplashSearchResponse(
    @field:SerializedName("results") val results: List<UnsplashPhoto>,
    @field:SerializedName("total_pages") val totalPages: Int
)
