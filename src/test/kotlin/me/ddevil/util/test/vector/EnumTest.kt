package me.ddevil.util.test.vector

import me.ddevil.util.enumValueWithIndex
import org.junit.Test
class EnumTest {
    @Test
    fun comp() {
        val enum = enumValueWithIndex<TestEnum>(2)
        println(enum)
    }
}

enum class TestEnum {
    A, B, C;
}