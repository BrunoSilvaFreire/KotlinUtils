package me.ddevil.util.exception

class IllegalValueTypeException(val expectedType: Class<*>, val typeFound: Class<*>) : IllegalStateException(generateMessage(expectedType, typeFound)) {
    companion object {
        fun generateMessage(expectedType: Class<*>, typeFound: Class<*>) = "Expected value of type ${expectedType.name}, but got ${typeFound.name}!"
    }

}