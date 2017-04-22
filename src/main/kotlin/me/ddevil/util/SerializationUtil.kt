package me.ddevil.util

import me.ddevil.util.exception.IllegalValueTypeException
import me.ddevil.util.exception.ValueNotFoundException
import me.ddevil.util.misc.Nameable
import me.ddevil.util.serialization.DependentLoader
import java.util.*

const val DEFAULT_NAME_IDENTIFIER = "name"
const val DEFAULT_ALIAS_IDENTIFIER = "alias"
const val DEFAULT_DESCRIPTION_IDENTIFIER = "description"
const val DEFAULT_DEPENDENCIES_IDENTIFIER = "dependencies"


fun Map<String, *>.getString(key: String): String = getOrException(key)

fun Map<String, *>.getNumber(key: String): Number = getOrException(key)

fun Map<String, *>.getFloat(key: String) = getNumber(key).toFloat()

fun Map<String, *>.getDouble(key: String) = getNumber(key).toDouble()

fun Map<String, *>.getInt(key: String) = getNumber(key).toInt()

fun Map<String, *>.getLong(key: String) = getNumber(key).toLong()
fun <V> Map<String, *>.getMap(key: String): Map<String, V> = getOrException(key)

fun Map<String, *>.getMapAny(key: String): Map<String, Any> = getMap(key)

fun Map<String, *>.getBoolean(key: String): Boolean = getOrException(key)

fun <T> Map<String, *>.getList(key: String): List<T> = getOrException(key)

inline fun <reified V : Any, FV> Map<String, *>.getAndTransform(key: String, transform: (V) -> (FV)): FV {
    return transform(getOrException<V>(key))
}

inline fun <reified T : Any> Map<String, *>.getOrException(key: String): T {
    val get = this[key] ?: throw ValueNotFoundException(key)
    return (get as? T) ?: throw IllegalValueTypeException(T::class.java, get.javaClass)
}

inline fun <reified T : Any> Map<String, *>.getOrElse(key: String, default: T): T {
    val get = this[key] ?: default
    return (get as? T) ?: throw IllegalValueTypeException(T::class.java, get.javaClass)
}

@JvmOverloads
fun <O : Nameable> loadAndResolveDependentNameables(
        objects: List<Map<String, Any>>,
        nameIdentifier: String = DEFAULT_NAME_IDENTIFIER,
        parentIdentifier: String = DEFAULT_DEPENDENCIES_IDENTIFIER,
        dependentLoader: DependentLoader<O>
): Collection<O> {
    //Objects to be loaded
    val serializedObjects = HashMap<String, Map<String, Any>>()
    //Objects already loaded
    val loadedObjects = HashMap<String, O>()
    //Map that defines which dependencies are whose
    val dependencyMap = HashMap<String, String>()

    //Pass objects to the serializedObjects map
    objects.forEach {
        val objectName = it[nameIdentifier].toString()
        serializedObjects.put(objectName, it)
    }

    //Pre-detect dependencies as pass them to the dependency map
    serializedObjects.entries
            .filter({ it.value.containsKey(parentIdentifier) })
            .forEach { dependencyMap.put(it.key, it.value[parentIdentifier].toString()) }

    //Load object
    for ((objectName, serializedObject) in serializedObjects) {
        //Check if was not loaded as a dependency
        if (objectName !in loadedObjects) {
            val obj = loadObject(objectName,
                    serializedObject,
                    dependencyMap,
                    dependentLoader,
                    serializedObjects,
                    loadedObjects) {
                name, loadedObj: O ->
                loadedObjects[name] = loadedObj
            }
            loadedObjects[objectName] = obj
        }
    }
    return loadedObjects.values
}

private fun <O> loadObject(
        objectName: String,
        serializedObject: Map<String, Any>,
        dependencyMap: Map<String, String>,
        dependentLoader: DependentLoader<O>,
        unloadedObjects: Map<String, Map<String, Any>>,
        loadedObjects: Map<String, O>,
        onObjectLoaded: (String, O) -> (Unit)
): O {
    var dependency: O? = null
    //Load object
    //Check if has a dependency of its own
    if (objectName in dependencyMap) {
        val dependencyName = dependencyMap[objectName]!!
        val serializedDependency = unloadedObjects[dependencyName] ?: throw IllegalStateException("Couldn't find serialized dependency $dependencyMap of dependant $objectName")
        dependency = loadObject(dependencyName,
                serializedDependency,
                dependencyMap,
                dependentLoader,
                unloadedObjects,
                loadedObjects,
                onObjectLoaded)
        onObjectLoaded(dependencyName, dependency!!)
    }
    return dependentLoader.load(serializedObject, loadedObjects, dependency)
}
