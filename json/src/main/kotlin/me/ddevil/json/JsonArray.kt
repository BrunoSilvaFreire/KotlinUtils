package me.ddevil.json

class JsonArray<T : Any?> : ArrayList<T>, JsonElement {
    constructor(vararg values: T) : this(values.toSet())
    constructor(initialCapacity: Int) : super(initialCapacity)
    constructor() : super()
    constructor(c: Collection<T>) : super(c)

    override fun toJson() = "[${this.joinToString {
        serializeValueToJson(it) ?: "null"
    }}]"
}
