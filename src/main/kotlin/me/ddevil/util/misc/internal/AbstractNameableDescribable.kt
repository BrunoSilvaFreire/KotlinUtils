package me.ddevil.util.misc.internal

import me.ddevil.util.getOrException
import me.ddevil.util.misc.Describable
import me.ddevil.util.misc.internal.AbstractNameable

abstract class AbstractNameableDescribable : AbstractNameable, Describable {

    final override var description: List<String>

    @JvmOverloads
    constructor(name: String, alias: String, description: List<String> = emptyList()) : super(name, alias) {
        this.description = description

    }

    constructor(map: Map<String, Any>, nameIdentifier: String, aliasIdentifier: String, descriptionIdentifier: String) : super(map, nameIdentifier, aliasIdentifier) {
        this.description = map.getOrException<List<String>>(descriptionIdentifier)
    }


}