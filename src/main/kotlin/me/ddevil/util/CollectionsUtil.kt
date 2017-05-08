package me.ddevil.util

import java.util.*

private val random = Random()

fun <T> Iterable<T>.random(): T {
    val pos = random.nextInt(this.count())
    return this.elementAt(pos)
}