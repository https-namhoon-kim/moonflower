package com.kmm.moonflower.core.resources

interface FileResourceReader {

    suspend fun getJsonFileToString(fileName : String) : String
}