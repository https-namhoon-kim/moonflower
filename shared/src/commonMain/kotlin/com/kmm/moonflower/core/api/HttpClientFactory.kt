package com.kmm.moonflower.core.api

import io.ktor.client.HttpClient

expect class HttpClientFactory {
    fun create(): HttpClient
}