package com.kmm.moonflower.core.utilities

actual fun String.sharedFormat(vararg args: Any?): String {
    return this.format(*args)
}
