package me.ddevil.util.test.vector

import me.ddevil.util.randomColor
import org.junit.Test
import java.util.*

class RandomTest {
    @Test
    fun color() {
        val random = Random()
        for (i in 0..19) {
            println(randomColor(random))
        }
    }
}