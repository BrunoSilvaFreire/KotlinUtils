package me.ddevil.json.exception

import me.ddevil.json.parse.JsonTokenType

class UnexpectedJsonTokenException : IllegalStateException {

    constructor(expectedTokenType: JsonTokenType,
                foundTokenType: JsonTokenType
    ) : super("Expected token of type '$expectedTokenType' but found '$foundTokenType'")

    constructor(position: Int) : super("Found an unexpected token while parsing json at position $position!")
}