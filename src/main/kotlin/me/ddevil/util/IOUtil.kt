package me.ddevil.util

import java.io.File
import java.io.InputStream
import java.net.URI
import java.net.URL
import java.nio.file.Paths

fun getCurrentExecutionPathFile() = File(".")
fun getCurrentExecutionPath() = Paths.get(getCurrentExecutionPathURI())
fun getCurrentExecutionPathURI() = URI.create(getCurrentExecutionPathString())
fun getCurrentExecutionPathString(): String = System.getProperty("user.dir")

fun Any.getResourceAsStream(path: String): InputStream {
    val stream = this::class.java.getResourceAsStream(path)
    return stream ?: throw IllegalArgumentException("Couldn't find any resource with this path! ($path)")
}

fun Any.getResource(path: String): URL {
    val stream = this::class.java.getResource(path)
    return stream ?: throw IllegalArgumentException("Couldn't find any resource with this path! ($path)")
}
