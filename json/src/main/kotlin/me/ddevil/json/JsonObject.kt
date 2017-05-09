package me.ddevil.json

import java.io.ByteArrayInputStream

class JsonObject : HashMap<String, Any?>, JsonElement {

    constructor() : super()

    constructor(initialCapacity: Int) : super(initialCapacity)

    constructor(initialCapacity: Int, loadFactor: Float) : super(initialCapacity, loadFactor)

    constructor(m: Map<String, Any?>) : super(m)

    fun toInputStream() = ByteArrayInputStream(toString().toByteArray())

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