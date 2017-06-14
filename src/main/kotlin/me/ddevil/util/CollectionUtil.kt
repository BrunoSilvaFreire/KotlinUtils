package me.ddevil.util

fun <C : MutableCollection<T>, T> C.append(value: T): C {
    add(value)
    return this
}