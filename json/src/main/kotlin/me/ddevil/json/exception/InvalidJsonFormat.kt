package me.ddevil.json.exception


class InvalidJsonFormat : IllegalArgumentException {
    companion object {
        const val MESSAGE = "The provided json is in an invalid format!"
    }

    constructor() : super(MESSAGE)
    constructor(cause: Throwable) : super(MESSAGE, cause)
}