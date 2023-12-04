package com.kmm.moonflower.core.resources


import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.resource

@OptIn(ExperimentalResourceApi::class)
class FileResourceReaderWithCompose : FileResourceReader {

    // https://stackoverflow.com/questions/75498653/sharing-resources-json-image-text-from-a-kotlin-multiplatform-module
    override suspend fun getJsonFileToString(fileName: String) =
        resource(fileName).readBytes().decodeToString()

    fun testAsync(filename: String, completionHandler: (String?, Throwable?) -> Unit) {
        val scope = MainScope()
        scope.launch {
            try {
                val result = getJsonFileToString(filename)
                completionHandler(result, null)
            } catch (e: Throwable) {
                completionHandler(null, e)
            }
        }
    }
}