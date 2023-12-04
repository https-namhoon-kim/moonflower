package com.kmm.moonflower.core.resources

import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.resource

@OptIn(ExperimentalResourceApi::class)
class FileResourceReaderWithCompose : FileResourceReader {

    // https://stackoverflow.com/questions/75498653/sharing-resources-json-image-text-from-a-kotlin-multiplatform-module
    override suspend fun getJsonFileToString(fileName: String) =
        resource(fileName).readBytes().decodeToString()
}