package com.kmm.moonflower.core.resources

import platform.Foundation.NSBundle
import platform.Foundation.NSData
import platform.Foundation.NSString
import platform.Foundation.NSURL
import platform.Foundation.NSUTF8StringEncoding
import platform.Foundation.create
import platform.Foundation.dataWithContentsOfURL

actual class FileResourceReaderPlatform : FileResourceReader {

      override suspend fun getJsonFileToString(fileName: String/* ex) plants */): String {
        val path = NSBundle.mainBundle.pathForResource("fileName", "json")
            ?: throw Exception("Cannot find resource: $fileName")
        val url = NSURL.fileURLWithPath(path)
        val data = NSData.dataWithContentsOfURL(url)
            ?: throw Exception("Cannot load data from resource: $fileName")
        val content = NSString.create(data, NSUTF8StringEncoding)
            ?: throw Exception("Cannot convert data to String for resource: $fileName")

        return content as String
    }

}