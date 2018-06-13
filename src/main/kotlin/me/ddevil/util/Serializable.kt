package me.ddevil.util

import java.io.Serializable

typealias Serialized = Map<String, Any?>

interface Serializable : Serializable {
    fun serialize(): Serialized
}