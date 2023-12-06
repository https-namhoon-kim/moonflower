package com.kmm.moonflower.core.resources

actual class FileResourceReaderPlatform : FileResourceReader {

    override suspend fun getJsonFileToString(fileName: String): String =
        this::class.java.classLoader.getResourceAsStream(fileName).bufferedReader()
            .use { it.readText() }
}