package me.ddevil.util.serialization

interface Deserializer<out O> : (Map<String, Any>) -> O