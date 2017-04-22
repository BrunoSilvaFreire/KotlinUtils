package me.ddevil.util

import com.google.common.collect.ImmutableList
import com.google.common.collect.ImmutableMap

fun <T> immutableListBuilder() = ImmutableList.builder<T>()!!

fun <K, V> immutableMapBuilder() = ImmutableMap.builder<K, V>()!!

fun immutableStringAnyMapBuilder() = immutableMapBuilder<String, Any>()

fun <K, V> ImmutableMap.Builder<K, V>.putIf(
        key: K,
        obj: V?,
        predicate: () -> Boolean
): ImmutableMap.Builder<K, V> {
    if (predicate()) {
        put(key, obj)
    }
    return this
}

fun <K, V> ImmutableMap.Builder<K, V>.putIfNotNull(key: K, obj: V?) = putIf(key, obj) { obj != null }

fun <K, V> ImmutableMap.Builder<K, V>.putAllNotNull(map: Map<K, V?>) = putAllIf(map) { key, value ->
    key != null && value != null
}

fun <K, V> ImmutableMap.Builder<K, V>.putAllIf(
        map: Map<K, V?>,
        predicate: () -> Boolean
): ImmutableMap.Builder<K, V> {
    if (predicate()) {
        putAll(map)
    }
    return this
}

fun <K, V> ImmutableMap.Builder<K, V>.putAllIf(
        map: Map<K, V?>,
        predicate: (K, V?) -> Boolean
): ImmutableMap.Builder<K, V> {
    for ((key, value) in map)
        if (predicate(key, value)) {
            this[key] = value
        }
    return this
}

operator fun <K, V> ImmutableMap.Builder<K, V>.set(key: K, obj: V?) {
    put(key, obj)
}
