package me.ddevil.json

class JsonArray : ArrayList<Any> {
    constructor(initialCapacity: Int) : super(initialCapacity)
    constructor() : super()
    constructor(c: Collection<Any>) : super(c)

    override fun toString(): String {
        return "[${this.joinToString()}]"
    }
}