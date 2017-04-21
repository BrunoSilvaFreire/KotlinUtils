package me.ddevil.util

import com.google.common.collect.ImmutableMap

fun <K, V> immutableMapBuilder() = ImmutableMap.builder<K, V>()!!

fun immutableStringAnyMapBuilder() = immutableMapBuilder<String, Any>()

fun ImmutableMap.Builder<String, Any>.putIf(
        key: String,
        obj: Any?,
        predicate: () -> Boolean
): ImmutableMap.Builder<String, Any> {
    if (predicate()) {
        put(key, obj)
    }
    return this
}

fun ImmutableMap.Builder<String, Any>.putIfNotNull(key: String, obj: Any?) = putIf(key, obj) { obj != null }

operator fun ImmutableMap.Builder<String, Any>.set(key: String, obj: Any?) {
    put(key, obj)
}