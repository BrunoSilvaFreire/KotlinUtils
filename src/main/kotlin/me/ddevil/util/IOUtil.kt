package me.ddevil.util

import java.io.InputStream
import java.net.URL

fun Any.getResourceAsStream(path: String): InputStream {
    val stream = this::class.java.getResourceAsStream(path)
    return stream ?: throw IllegalArgumentException("Couldn't find any resource with this path! ($path)")
}

fun Any.getResource(path: String): URL {
    val stream = this::class.java.getResource(path)
    return stream ?: throw IllegalArgumentException("Couldn't find any resource with this path! ($path)")
}
