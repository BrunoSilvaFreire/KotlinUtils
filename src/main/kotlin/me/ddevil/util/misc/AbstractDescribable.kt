package me.ddevil.util.misc

import me.ddevil.util.getOrException
import me.ddevil.util.misc.Describable

abstract class AbstractDescribable : Describable {

    final override var description: List<String>

    @JvmOverloads
    constructor(description: List<String> = emptyList()) {
        this.description = description
    }

    constructor(map: Map<String, Any>, descriptionIdentifier: String) {
        this.description = map.getOrException<List<String>>(descriptionIdentifier)
    }


}

