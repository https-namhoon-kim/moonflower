package com.kmm.moonflower.core.resources

actual class FileResourceReaderPlatform {

    actual suspend fun getJsonFileToString(fileName: String): String =
        this::class.java.classLoader.getResourceAsStream(fileName).bufferedReader().use { it.readText() }
}