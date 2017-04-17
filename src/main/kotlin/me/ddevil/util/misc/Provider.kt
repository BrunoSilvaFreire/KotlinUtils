package me.ddevil.util.misc

interface Provider<in K, V> {

    operator fun get(key: K): V

    operator fun contains(key: K): Boolean

    fun save(value: V)

    fun delete(key: K): Set<V>

}