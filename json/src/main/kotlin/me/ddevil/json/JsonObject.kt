package me.ddevil.json

import me.ddevil.util.exception.IllegalValueTypeException
import me.ddevil.util.exception.ValueNotFoundException
import java.io.ByteArrayInputStream

class JsonObject : HashMap<String, Any?>, JsonElement {

    constructor() : super()

    constructor(initialCapacity: Int) : super(initialCapacity)

    constructor(initialCapacity: Int, loadFactor: Float) : super(initialCapacity, loadFactor)

    constructor(m: Map<String, Any?>) : super(m)

    fun toInputStream() = ByteArrayInputStream(toString().toByteArray())
    fun getString(key: String): String = getOrException(String::class.java, key)

    fun getNumber(key: String): Number = getOrException(Number::class.java, key)

    fun getFloat(key: String) = getNumber(key).toFloat()

    fun getDouble(key: String) = getNumber(key).toDouble()

    fun getInt(key: String) = getNumber(key).toInt()

    fun getLong(key: String) = getNumber(key).toLong()

    fun getJson(key: String) = getOrException(JsonObject::class.java, key)

    fun getBoolean(key: String): Boolean = getOrException(Boolean::class.java, key)

    fun getJsonArray(key: String): JsonArray<*> = getOrException(JsonArray::class.java, key)

    fun getStringOrNull(key: String): String? = getOrNull(String::class.java, key)

    fun getNumberOrNull(key: String): Number? = getOrNull(Number::class.java, key)

    fun getFloatOrNull(key: String): Float? = getNumberOrNull(key)?.toFloat()

    fun getDoubleOrNull(key: String): Double? = getNumberOrNull(key)?.toDouble()

    fun getIntOrNull(key: String): Int? = getNumberOrNull(key)?.toInt()

    fun getLongOrNull(key: String): Long? = getNumberOrNull(key)?.toLong()

    fun getJsonOrNull(key: String): JsonObject? = getOrNull(JsonObject::class.java, key)


    fun getBooleanOrNull(key: String): Boolean? = getOrNull(Boolean::class.java, key)

    fun getListOrNull(key: String): JsonArray<*>? = getOrNull(JsonArray::class.java, key)


    @Suppress("UNCHECKED_CAST")
    fun <T : Any> getOrException(clazz: Class<T>, key: String): T {
        val get = this[key] ?: throw ValueNotFoundException(key)
        return (get as? T) ?: throw IllegalValueTypeException(clazz, get.javaClass)
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : Any> getOrNull(clazz: Class<T>, key: String): T? {
        val get = this[key] ?: return null
        return get as? T ?: throw IllegalValueTypeException(clazz, get.javaClass)
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : Any> getOrElse(clazz: Class<T>, key: String, default: T): T {
        val get = this[key] ?: default
        return (get as? T) ?: throw IllegalValueTypeException(clazz, get.javaClass)
    }

    override fun toJson(): String {
        var string = "{"
        for ((index, entry) in entries.withIndex()) {
            val key = entry.key
            val value = entry.value
            string += "\"$key\": ${serializeValueToJson(value)}"
            if (index != size - 1) {
                string += ","
            }
        }
        return string + "}"
    }


}