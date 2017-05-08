package me.ddevil.json

class JsonObject : HashMap<String, Any> {

    constructor() : super()

    constructor(initialCapacity: Int) : super(initialCapacity)

    constructor(initialCapacity: Int, loadFactor: Float) : super(initialCapacity, loadFactor)

    constructor(m: Map<String, *>) : super(m)

    override fun toString(): String {
        var string = "{"
        for ((index, entry) in entries.withIndex()) {
            val key = entry.key
            val value = entry.value
            string += "\"$key\": ${serializeValue(value)}"
            if (index != size - 1) {
                string += ","
            }
        }
        return string + "}"
    }


}