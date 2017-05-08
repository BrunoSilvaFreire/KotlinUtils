package me.ddevil.json



fun Map<*, *>.toJson(): JsonObject {
    val json = JsonObject()
    for ((key, value) in this) {
        if (value != null) {
            json[key.toString()] = serializeValue(value)
        }
    }
    return json
}

fun Iterable<*>.toJsonArray(): JsonArray {
    val json = JsonArray()
    this.filterNotNull().mapTo(json, ::serializeValue)
    return json
}

fun serializeValue(value: Any): Any {
    if (value is Map<*, *>) {
        return value.toJson()
    }
    if (value is String) {
        return "\"$value\""
    }
    if (value is Number || value is Boolean) {
        return value
    }
    if (value is Iterable<*>) {
        return value.toJsonArray()
    }
    return value.toString()
}
