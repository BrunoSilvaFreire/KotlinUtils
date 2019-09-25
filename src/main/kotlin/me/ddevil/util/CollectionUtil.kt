package me.ddevil.util

fun <C : MutableCollection<T>, T> C.append(value: T): C {
    add(value)
    return this
}

fun <E> list(builder: ArrayList<E>.() -> Unit): ArrayList<E> {
    val list = ArrayList<E>()
    list.builder()
    return list
}