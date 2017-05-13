package me.ddevil.json.parse

class JsonStateMachine {
    private val map = hashMapOf<TokenStatus, (world: JsonWorld, token: JsonToken) -> JsonWorld>()

    fun put(status: JsonParsingStatus,
            tokenType: JsonTokenType,
            processor: (world: JsonWorld, token: JsonToken) -> JsonWorld) {
        map.put(TokenStatus(status, tokenType), processor)
    }

    fun next(world: JsonWorld, token: JsonToken): JsonWorld {
        val pair = TokenStatus(world.status, token.type)
        val processor = map[pair]
        val result = if (processor != null) {
            processor(world, token)
        } else {
            throw RuntimeException("No state found: ${world.status} $token")
        }

        return result
    }
}