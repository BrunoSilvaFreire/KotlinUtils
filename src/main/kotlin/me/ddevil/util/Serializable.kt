package me.ddevil.util

import java.io.Serializable

interface Serializable : Serializable {
    fun serialize(): Map<String, Any>
}