package me.ddevil.json.parse

import java.io.InputStream
import java.io.Reader
import java.nio.charset.Charset
import java.util.regex.Pattern

const val NUMBER_PATTERN_STRING = "[-]?[0-9]+"
val NUMBER_PATTERN = Pattern.compile(NUMBER_PATTERN_STRING)
const val DOUBLE_PATTERN_STRING = "$NUMBER_PATTERN_STRING((\\.[0-9]+)?([eE][-+]?[0-9]+)?)"
val DOUBLE_PATTERN = Pattern.compile(DOUBLE_PATTERN_STRING)

class JsonLexer {
    private val reader: Reader
    private var index = 0

    @JvmOverloads
    constructor(stream: InputStream, charset: Charset = Charsets.UTF_8) : this(stream.reader(charset))

    constructor(reader: Reader) {
        this.reader = reader.buffered()
    }

    private var next: Char? = null

    private fun isDone(): Boolean {
        if (next != null) {
            return false
        }
        index++
        val read = reader.read()
        if (read == -1) return true
        next = read.toChar()
        return false
    }

    private fun nextChar(): Char {
        if (isDone()) throw IllegalStateException("Cannot get next char: EOF reached")
        val c = next!!
        next = null
        return c
    }

    private fun peekChar(): Char {
        if (isDone()) throw IllegalStateException("Cannot peek next char: EOF reached")
        return next!!
    }

    fun isSpace(c: Char) = c == ' ' || c == '\r' || c == '\n' || c == '\t'

    val BOOLEAN_LETTERS = "falsetrue".toSet()

    private fun isBooleanLetter(c: Char): Boolean {
        return BOOLEAN_LETTERS.contains(Character.toLowerCase(c))
    }

    val NULL_LETTERS = "null".toSet()

    fun isValueLetter(c: Char): Boolean {
        return c == '-' || c == '+' || c == '.' || c.isDigit() || isBooleanLetter(c)
                || c in NULL_LETTERS
    }

    fun nextToken(): JsonToken {

        if (isDone()) {
            return JsonToken.EOF
        }

        var tokenType: JsonTokenType
        var c = nextChar()
        val currentValue = StringBuilder()
        var jsonValue: Any? = null

        while (!isDone() && isSpace(c)) {
            c = nextChar()
        }

        if ('"' == c) {
            tokenType = JsonTokenType.VALUE
            loop@
            do {
                if (isDone()) {
                    throw RuntimeException("Unterminated string")
                }

                c = nextChar()
                when (c) {
                    '\\' -> {
                        if (isDone()) {
                            throw RuntimeException("Unterminated string")
                        }

                        c = nextChar()
                        when (c) {
                            '\\' -> currentValue.append("\\")
                            '/' -> currentValue.append("/")
                            'b' -> currentValue.append("\b")
                            'f' -> currentValue.append("\u000c")
                            'n' -> currentValue.append("\n")
                            'r' -> currentValue.append("\r")
                            't' -> currentValue.append("\t")
                            'u' -> {
                                val unicodeChar = StringBuilder(4)
                                        .append(nextChar())
                                        .append(nextChar())
                                        .append(nextChar())
                                        .append(nextChar())

                                val intValue = java.lang.Integer.parseInt(unicodeChar.toString(), 16)
                                currentValue.append(intValue.toChar())
                            }
                            else -> currentValue.append(c)
                        }
                    }
                    '"' -> break@loop
                    else -> currentValue.append(c)
                }
            } while (true)

            jsonValue = currentValue.toString()
        } else if ('{' == c) {
            tokenType = JsonTokenType.LEFT_BRACKET
        } else if ('}' == c) {
            tokenType = JsonTokenType.RIGHT_BRACKET
        } else if ('[' == c) {
            tokenType = JsonTokenType.LEFT_SQUARE
        } else if (']' == c) {
            tokenType = JsonTokenType.RIGHT_SQUARE
        } else if (':' == c) {
            tokenType = JsonTokenType.COLON
        } else if (',' == c) {
            tokenType = JsonTokenType.COMMA
        } else if (!isDone()) {
            while (isValueLetter(c)) {
                currentValue.append(c)
                if (!isValueLetter(peekChar())) {
                    break
                } else {
                    c = nextChar()
                }
            }
            val v = currentValue.toString()
            if (NUMBER_PATTERN.matcher(v).matches()) {
                try {
                    jsonValue = java.lang.Integer.parseInt(v)
                } catch (e: NumberFormatException) {
                    try {
                        jsonValue = java.lang.Long.parseLong(v)
                    } catch(e: NumberFormatException) {
                        jsonValue = java.math.BigInteger(v)
                    }
                }
            } else if (DOUBLE_PATTERN.matcher(v).matches()) {
                jsonValue = java.lang.Double.parseDouble(v)
            } else if ("true" == v.toLowerCase()) {
                jsonValue = true
            } else if ("false" == v.toLowerCase()) {
                jsonValue = false
            } else if (v == "null") {
                jsonValue = null
            } else {
                throw RuntimeException("Unexpected character at position $index: '$c (${c.toInt()})'")
            }

            tokenType = JsonTokenType.VALUE
        } else {
            tokenType = JsonTokenType.EOF
        }

        return JsonToken(tokenType, jsonValue)
    }
}

