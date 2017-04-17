package me.ddevil.util.serialization

interface DependentLoader<O> {
    fun load(serializedObject: Map<String, Any>,
             otherLoadedObject: Map<String, O>,
             foundDependency: O?): O
}
