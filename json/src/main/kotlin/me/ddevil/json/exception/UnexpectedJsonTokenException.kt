package me.ddevil.json.exception

import me.ddevil.json.parse.JsonToken

class UnexpectedJsonTokenException : IllegalStateException {

    constructor(expectedToken: JsonToken,
                foundToken: JsonToken
    ) : super("Expected token of type '$expectedToken' but found '$foundToken'")

    constructor(position: Int) : super("Found an unexpected token while parsing json at position $position!")
}