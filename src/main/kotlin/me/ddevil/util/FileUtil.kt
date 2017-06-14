package me.ddevil.util

import java.io.File

fun File.isEmpty() = listFiles().isEmpty()
fun File.isNotEmpty() = listFiles().isNotEmpty()