package com.kmm.moonflower.core.resources


expect class FileResourceReaderPlatform : FileResourceReader {
//    override suspend fun getJsonFileToString(fileName: String): String
}

// TODO
// 1. adding 'compose.ios.resources.sync=false' to your gradle.properties
// 2. cocoapods {
//      extraSpecAttributes["resources"] = "['src/commonMain/resources/**', 'src/iosMain/resources/**']"
//    }