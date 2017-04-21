package me.ddevil.util.test.vector

import me.ddevil.util.getString
import me.ddevil.util.immutableStringAnyMapBuilder
import me.ddevil.util.putIfNotNull
import org.junit.Test

class GuavaTest {
    @Test
    fun builder() {
        val key = "test"
        val value = null
        val s = immutableStringAnyMapBuilder().putIfNotNull(key, value).build()
        s.getString(key)
    }
}