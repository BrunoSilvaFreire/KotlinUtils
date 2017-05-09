package me.ddevil.json.parse

enum class JsonToken(val char: Char) {
    RIGHT_BRACKET('{'),
    LEFT_BRACKET('}'),
    RIGHT_SQUARE('{'),
    LEFT_SQUARE('}'),
    QUOTES('"'),
    COMMA(','),
    COLON(':');

    fun valid(c: Char) = c == char

    companion object {
        fun ofCharSafe(char: Char) = values().firstOrNull { it.char == char }
        fun ofChar(char: Char) = values().first { it.char == char }
    }
}

internal fun Char.toJsonToken() = JsonToken.ofChar(this)