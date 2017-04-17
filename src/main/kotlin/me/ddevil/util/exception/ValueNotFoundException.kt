package me.ddevil.util.exception

class ValueNotFoundException : IllegalStateException {

    constructor(cause: Throwable, desiredObject: String) : super(generateMessage(desiredObject), cause)

    constructor(desiredObject: String) : super(generateMessage(desiredObject))

    companion object {
        fun generateMessage(desiredObject: String) = "Couldn't find object $desiredObject!"
    }

}