package me.ddevil.util

import com.google.common.base.Preconditions
import com.google.common.collect.ImmutableList
import com.google.common.collect.ImmutableMap

fun <K, V> immutableMap(init: ImmutableMap.Builder<K, V>.() -> (Unit)): ImmutableMap<K, V> {
    val b = ImmutableMap.builder<K, V>()
    b.init()
    return b.build()
}

fun checkArgument(expression: Boolean) = Preconditions.checkArgument(expression)

fun checkArgument(expression: Boolean, errorMessage: Any) = Preconditions.checkArgument(expression, errorMessage)

fun checkArgument(expression: Boolean,
                  vararg errorMessageArgs: Array<out Any>,
                  errorMessageTemplate: String) = Preconditions.checkArgument(expression,
        errorMessageTemplate,
        errorMessageArgs)

fun checkState(expression: Boolean) = Preconditions.checkState(expression)

fun checkState(expression: Boolean, errorMessage: Any) = Preconditions.checkState(expression, errorMessage)

fun checkState(
        expression: Boolean,
        vararg errorMessageArgs: Array<out Any>,
        errorMessageTemplate: String
) = Preconditions.checkState(
        expression,
        errorMessageTemplate,
        errorMessageArgs)

fun checkPositionIndex(index: Int, size: Int) = Preconditions.checkPositionIndex(index, size)

fun checkPositionIndex(index: Int, size: Int, desc: String?) = Preconditions.checkPositionIndex(index, size, desc)

fun checkPositionIndexes(start: Int, end: Int, size: Int) = Preconditions.checkPositionIndexes(start, end, size)

fun checkElementIndex(index: Int, size: Int) = Preconditions.checkElementIndex(index, size)

fun checkElementIndex(index: Int, size: Int, desc: String?) = Preconditions.checkElementIndex(index, size, desc)

//Immutable shit
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

fun <K> ImmutableMap.Builder<K, Any>.putSerializable(
        key: K,
        obj: Serializable
): ImmutableMap.Builder<K, Any> {
    put(key, obj.serialize())
    return this
}

fun <K> ImmutableMap.Builder<K, Any>.putSerializableIf(
        key: K,
        obj: Serializable,
        predicate: () -> Boolean
): ImmutableMap.Builder<K, Any> {
    if (predicate()) {
        putSerializable(key, obj)
    }
    return this
}

fun <K> ImmutableMap.Builder<K, Any>.putSerializableIfNotNull(
        key: K,
        obj: Serializable?
): ImmutableMap.Builder<K, Any> {
    if (obj != null) {
        putSerializable(key, obj)
    }
    return this
}

fun <K> ImmutableMap.Builder<K, Any>.putSerializables(
        key: K,
        objs: Iterable<Serializable>
): ImmutableMap.Builder<K, Any> {
    put(key, objs.map(Serializable::serialize))
    return this
}

fun <K> ImmutableMap.Builder<K, Any>.putSerializablesIf(
        key: K,
        objs: Iterable<Serializable>,
        predicate: () -> Boolean
): ImmutableMap.Builder<K, Any> {
    if (predicate()) {
        putSerializables(key, objs)
    }
    return this
}

fun <K> ImmutableMap.Builder<K, Any>.putSerializablesIfNotNull(
        key: K,
        objs: List<Serializable?>
): ImmutableMap.Builder<K, Any> {
    putSerializables(key, objs.filterNotNull())
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
