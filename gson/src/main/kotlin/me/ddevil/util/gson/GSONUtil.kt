package me.ddevil.util.gson

import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonPrimitive

fun Any.toJson(gson: Gson): String = gson.toJson(this)

fun Any.toJsonTree(gson: Gson) = gson.toJsonTree(this)

fun JsonObject.asMap(): Map<String, Any> {
    val map = HashMap<String, Any>()
    for ((key, value) in entrySet()) {
        val jsonValue = value.getValue()
        if (jsonValue != null) {
            map[key] = jsonValue
        }
    }
    return map
}

fun JsonElement.getValue(): Any? {
    if (isJsonObject) {
        return asJsonObject.asMap()
    }
    if (isJsonArray) {
        return asJsonArray.map(JsonElement::getValue).toList()
    }
    if (isJsonNull) {
        return null
    }
    if (isJsonPrimitive) {
        return asJsonPrimitive.getPrimitiveValue()
    }
    throw IllegalStateException("Unknown json type.")
}

fun JsonPrimitive.getPrimitiveValue(): Any? {
    if (isBoolean) {
        return asBoolean
    }
    if (isString) {
        return asString
    }
    if (isNumber) {
        return asNumber
    }
    throw IllegalStateException("Unknown primitive value.")
}
