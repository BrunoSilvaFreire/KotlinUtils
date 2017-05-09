package me.ddevil.json

import me.ddevil.util.Serializable

fun <T : Any> jsonArray(init: JsonArray<T>.() -> Unit): JsonArray<T> {
    val json = JsonArray<T>()
    json.init()
    return json
}

fun json(init: JsonObject.() -> Unit): JsonObject {
    val json = JsonObject()
    json.init()
    return json
}

fun Map<*, *>.toJsonObject(): JsonObject {
    if (this is JsonObject) {
        return this
    }
    val json = JsonObject()
    for ((key, value) in this) {
        json[key.toString()] = serializeValueToJson(value)

    }
    return json
}

fun <T : Any> Iterable<T>.toJsonArray() = JsonArray(this.toSet())

internal fun serializeValueToJson(value: Any?): String? {
    if (value == null) {
        return null
    }
    if (value is JsonObject) {
        return value.toJson()
    }
    if (value is Serializable) {
        return value.serialize().toJsonObject().toJson()
    }
    if (value is Map<*, *>) {
        return value.toJsonObject().toJson()
    }
    if (value is ByteArray) {
        return "\"${String(value)}\""
    }
    if (value is String) {
        return "\"$value\""
    }
    if (value is Number || value is Boolean) {
        return value.toString()
    }
    if (value is Iterable<*>) {
        return (value as Iterable<Any>).toJsonArray().toJson()
    }
    return value.toString()
}
