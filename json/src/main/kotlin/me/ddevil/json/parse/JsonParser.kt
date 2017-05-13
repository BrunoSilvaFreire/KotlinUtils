package me.ddevil.json.parse

import me.ddevil.json.JsonArray
import me.ddevil.json.JsonObject
import java.io.File
import java.io.InputStream
import java.io.Reader
import java.io.StringReader
import java.nio.charset.Charset

class JsonParser {
    val verbose = true

    fun log(s: String) {
        if (verbose) {
            println(s)
        }
    }

    fun parseObject(rawValue: StringBuilder) = parse(rawValue) as JsonObject

    fun parseObject(json: String) = parse(json) as JsonObject

    @JvmOverloads
    fun parseObject(
            inputStream: InputStream,
            charset: Charset = Charsets.UTF_8
    ) = parse(inputStream, charset) as JsonObject

    @JvmOverloads
    fun parseObject(file: File, charset: Charset = Charsets.UTF_8) = parse(file, charset) as JsonObject

    fun parseObject(reader: Reader) = parse(reader) as JsonObject

    fun parseArray(rawValue: StringBuilder) = parse(rawValue) as JsonArray<*>

    fun parseArray(json: String) = parse(json) as JsonArray<*>

    @JvmOverloads
    fun parseArray(
            inputStream: InputStream,
            charset: Charset = Charsets.UTF_8
    ) = parse(inputStream, charset) as JsonArray<*>

    fun parseArray(file: File, charset: Charset = Charsets.UTF_8) = parse(file, charset) as JsonArray<*>

    fun parseArray(reader: Reader) = parse(reader) as JsonArray<*>

    fun parse(json: String) = parse(StringReader(json))

    fun parse(rawValue: StringBuilder): Any? = StringReader(rawValue.toString()).use {
        parse(it)
    }

    @JvmOverloads
    fun parse(file: File, charset: Charset = Charsets.UTF_8) = parse(file.reader(charset))

    @JvmOverloads
    fun parse(inputStream: InputStream, charset: Charset = Charsets.UTF_8): Any? {
        return parse(inputStream.reader(charset))
    }

    fun parse(reader: Reader): Any? {

        val sm = JsonStateMachine()
        sm.put(JsonParsingStatus.INIT, JsonTokenType.VALUE, { world: JsonWorld, token: JsonToken ->
            world.pushAndSet(JsonParsingStatus.IN_FINISHED_VALUE, token.value!!)
        })
        sm.put(JsonParsingStatus.INIT, JsonTokenType.LEFT_BRACKET, { world: JsonWorld, token: JsonToken ->
            world.pushAndSet(JsonParsingStatus.IN_OBJECT, JsonObject())
        })
        sm.put(JsonParsingStatus.INIT, JsonTokenType.LEFT_SQUARE, { world: JsonWorld, token: JsonToken ->
            world.pushAndSet(JsonParsingStatus.IN_ARRAY, JsonArray<Any>())
        })
        // else error

        sm.put(JsonParsingStatus.IN_FINISHED_VALUE, JsonTokenType.EOF, { world: JsonWorld, token: JsonToken ->
            world.result = world.popValue()
            world
        })
        // else error


        sm.put(JsonParsingStatus.IN_OBJECT, JsonTokenType.COMMA, { world: JsonWorld, token: JsonToken ->
            world
        })
        sm.put(JsonParsingStatus.IN_OBJECT, JsonTokenType.VALUE, { world: JsonWorld, token: JsonToken ->
            world.pushAndSet(JsonParsingStatus.PASSED_PAIR_KEY, token.value!!)
        })
        sm.put(JsonParsingStatus.IN_OBJECT, JsonTokenType.RIGHT_BRACKET, { world: JsonWorld, token: JsonToken ->
            if (world.hasValues()) {
                world.popStatus()
                world.popValue()
                world.status = world.peekStatus()
            } else {
                world.status = JsonParsingStatus.IN_FINISHED_VALUE
            }
            world
        })


        sm.put(JsonParsingStatus.PASSED_PAIR_KEY, JsonTokenType.COLON, { world: JsonWorld, token: JsonToken ->
            world
        })
        sm.put(JsonParsingStatus.PASSED_PAIR_KEY, JsonTokenType.VALUE, { world: JsonWorld, token: JsonToken ->
            world.popStatus()
            val key = world.popValue() as String
            world.parent = world.getFirstObject()
            world.parent.put(key, token.value)
            world.status = world.peekStatus()
            world
        })
        sm.put(JsonParsingStatus.PASSED_PAIR_KEY, JsonTokenType.LEFT_SQUARE, { world: JsonWorld, token: JsonToken ->
            world.popStatus()
            val key = world.popValue() as String
            world.parent = world.getFirstObject()
            val newArray = JsonArray<Any>()
            world.parent.put(key, newArray)
            world.pushAndSet(JsonParsingStatus.IN_ARRAY, newArray)
        })
        sm.put(JsonParsingStatus.PASSED_PAIR_KEY, JsonTokenType.LEFT_BRACKET, { world: JsonWorld, token: JsonToken ->
            world.popStatus()
            val key = world.popValue() as String
            world.parent = world.getFirstObject()
            val newObject = JsonObject()
            world.parent.put(key, newObject)
            world.pushAndSet(JsonParsingStatus.IN_OBJECT, newObject)
        })
        // else error

        sm.put(JsonParsingStatus.IN_ARRAY, JsonTokenType.COMMA, { world: JsonWorld, token: JsonToken ->
            world
        })
        sm.put(JsonParsingStatus.IN_ARRAY, JsonTokenType.VALUE, { world: JsonWorld, token: JsonToken ->
            val value = world.getFirstArray()
            value.add(token.value)
            world
        })
        sm.put(JsonParsingStatus.IN_ARRAY, JsonTokenType.RIGHT_SQUARE, { world: JsonWorld, token: JsonToken ->
            if (world.hasValues()) {
                world.popStatus()
                world.popValue()
                world.status = world.peekStatus()
            } else {
                world.status = JsonParsingStatus.IN_FINISHED_VALUE
            }
            world
        })
        sm.put(JsonParsingStatus.IN_ARRAY, JsonTokenType.LEFT_BRACKET, { world: JsonWorld, token: JsonToken ->
            val value = world.getFirstArray()
            val newObject = JsonObject()
            value.add(newObject)
            world.pushAndSet(JsonParsingStatus.IN_OBJECT, newObject)
        })
        sm.put(JsonParsingStatus.IN_ARRAY, JsonTokenType.LEFT_SQUARE, { world: JsonWorld, token: JsonToken ->
            val value = world.getFirstArray()
            val newArray = JsonArray<Any>()
            value.add(newArray)
            world.pushAndSet(JsonParsingStatus.IN_ARRAY, newArray)
        })
        // else error

        val lexer = JsonLexer(reader)

        var world = JsonWorld(JsonParsingStatus.INIT)
        do {
            val token = lexer.nextToken()
            log("JsonToken: $token")
            world = sm.next(world, token)
        } while (token.type != JsonTokenType.EOF)

        return world.result
    }
}