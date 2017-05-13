package me.ddevil.json.parse

data class JsonToken(val type: JsonTokenType, val value: Any?) {
    companion object {
        val EOF = JsonToken(JsonTokenType.EOF, null)
    }
}