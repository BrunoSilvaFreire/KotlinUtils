package me.ddevil.json.parse

enum class JsonParsingStatus {
    INIT,
    IN_FINISHED_VALUE,
    IN_OBJECT,
    IN_ARRAY,
    PASSED_PAIR_KEY,
    PAIR_VALUE,
    IN_ERROR,
    EOF
}