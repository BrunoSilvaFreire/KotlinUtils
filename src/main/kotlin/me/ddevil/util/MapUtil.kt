package me.ddevil.util

import java.util.*


private val random = Random()

fun <K, V> Map<K, V>.invert(): Map<V, K> {
    val map = HashMap<V, K>()
    for ((k, v) in entries) {
        if (map.containsKey(v)) {
            throw IllegalStateException("Found 2 keys that point to the same value ($v)! ($k, ${map[v]}")
        }
        map[v] = k
    }
    return map
}

fun <K, V> Map<K, V>.random(): Map.Entry<K, V> {
    val entries = entries.toList()
    return entries[random.nextInt(entries.size)]
}

fun <K, V : Comparable<V>> Map<K, V>.getTop(max: Int): List<K> {
    if (isEmpty()) {
        return Collections.emptyList()
    }
    val set = ArrayList<K>(keys)
    Collections.sort(set) {
        a, b ->
        val va = this[a] ?: return@sort -1
        val vb = this[b] ?: return@sort 1
        return@sort -va.compareTo(vb)
    }
    return set.slice(0..max - 1)
}

fun <K, V : Comparable<V>> Map<K, V>.getMin(max: Int): List<K> {
    if (isEmpty()) {
        return Collections.emptyList()
    }
    val set = ArrayList<K>(keys)
    Collections.sort(set) {
        a, b ->
        val va = this[a] ?: return@sort 1
        val vb = this[b] ?: return@sort -1
        return@sort va.compareTo(vb)
    }
    return set.slice(0..max - 1)
}

fun <K, V : Comparable<V>> Map<K, V>.max(): K {
    if (isEmpty()) {
        throw IllegalStateException("Map is empty!")
    }
    var highestKey: K? = null
    var highestValue: V? = null
    for ((key, value) in this.entries) {
        if (highestValue == null || value > highestValue) {
            highestValue = value
            highestKey = key

        }
    }
    return highestKey ?: throw IllegalStateException("Couldn't find max value. This shouldn't happen!")
}

fun <K, V : Comparable<V>> Map<K, V>.min(): K {
    if (isEmpty()) {
        throw IllegalStateException("Map is empty!")
    }
    var highestKey: K? = null
    var highestValue: V? = null
    for ((key, value) in this.entries) {
        if (highestValue == null || value < highestValue) {
            highestValue = value
            highestKey = key

        }
    }
    return highestKey ?: throw IllegalStateException("Couldn't find max value. This shouldn't happen!")
}
