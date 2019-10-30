package me.ddevil.util

import java.io.File
import java.io.InputStream
import java.net.URI
import java.net.URL
import java.nio.file.Path
import java.nio.file.Paths

fun workingDirectoryFile() = File(".")
fun workingDirectoryPath(): Path = Paths.get(workingDirectoryURI())
fun workingDirectoryURI(): URI = URI.create(workingDirectoryString())
fun workingDirectoryString(): String = System.getProperty("user.dir")

inline fun <reified T> getResourceAsStream(path: String): InputStream {
    val stream = T::class.java.getResourceAsStream(path)
    return stream ?: throw IllegalArgumentException("Couldn't find any resource with this path! ($path)")
}


inline fun <reified T> getResource(path: String): URL {
    val stream = T::class.java.getResource(path)
    return stream ?: throw IllegalArgumentException("Couldn't find any resource with this path! ($path)")
}