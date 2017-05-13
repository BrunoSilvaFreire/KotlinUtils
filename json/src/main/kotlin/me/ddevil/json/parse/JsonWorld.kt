package me.ddevil.json.parse

import me.ddevil.json.JsonArray
import me.ddevil.json.JsonObject
import java.util.*

class JsonWorld(var status: JsonParsingStatus) {
    private val statusStack = LinkedList<JsonParsingStatus>()
    private val valueStack = LinkedList<Any>()
    var result: Any? = null
    var parent = JsonObject()

    fun pushAndSet(status: JsonParsingStatus, value: Any): JsonWorld {
        pushStatus(status)
        pushValue(value)
        this.status = status
        return this
    }

    fun pushStatus(status: JsonParsingStatus): JsonWorld {
        statusStack.addFirst(status)
        return this
    }

    fun pushValue(value: Any): JsonWorld {
        valueStack.addFirst(value)
        return this
    }

    fun popValue(): Any {
        return valueStack.removeFirst()
    }

    fun popStatus(): JsonParsingStatus {
        return statusStack.removeFirst()
    }

    fun getFirstObject(): JsonObject {
        return valueStack.first as JsonObject
    }

    @Suppress("UNCHECKED_CAST")
    fun getFirstArray(): JsonArray<Any?> {
        return valueStack.first as JsonArray<Any?>
    }

    fun peekStatus(): JsonParsingStatus {
        return statusStack.get(0)
    }

    fun hasValues(): Boolean {
        return valueStack.size > 1
    }
}