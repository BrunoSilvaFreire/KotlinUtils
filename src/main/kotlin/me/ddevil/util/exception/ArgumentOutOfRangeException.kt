package me.ddevil.util.exception

class ArgumentOutOfRangeException : IllegalArgumentException {
    constructor(argumentName: String) : super("The provided argument '$argumentName' is out of range!")
    constructor(
            argumentName: String,
            argumentValue: Any
    ) : super("The provided argument '$argumentName' (value=$argumentValue) is out of range!")
}