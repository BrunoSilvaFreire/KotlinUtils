package me.ddevil.util

import com.google.common.collect.Multimap

operator fun <K, V> Multimap<K, V>.set(key: K, value: V) {
    this.put(key, value)
}

operator fun <K, V> Multimap<K, V>.contains(key: K) = containsKey(key)


operator fun <K, V> Multimap<K, V>.minusAssign(value: V) {
    for (key in keys()) {
        if (containsEntry(key, value)) {
            remove(key, value)
        }
    }
}