package me.ddevil.util.serialization

interface Serializer<in T> {
    fun serialize(value: T): Map<String, Any>

}