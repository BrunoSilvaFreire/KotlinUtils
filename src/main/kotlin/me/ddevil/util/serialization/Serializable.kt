package me.ddevil.util.serialization

import java.io.Serializable

interface Serializable : Serializable {

    fun serialize(): Map<String, Any>

}