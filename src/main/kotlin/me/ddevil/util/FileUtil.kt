package me.ddevil.util

import java.io.File

fun File.hasChildren() = listFiles().isEmpty()
