package me.ddevil.util.misc.internal

import me.ddevil.util.getOrException
import me.ddevil.util.misc.Nameable
import me.ddevil.util.serialization.Serializable
abstract class AbstractNameable : Nameable {


    final override var name: String
    final override var alias: String

    constructor(name: String, alias: String) {
        this.name = name
        this.alias = alias
    }

    constructor(map: Map<String, Any>, nameIdentifier: String, aliasIdentifier: String) {
        this.name = map.getOrException(nameIdentifier)
        this.alias = map.getOrException(aliasIdentifier)
    }

    override val fullName get() = "$name($alias)"

}