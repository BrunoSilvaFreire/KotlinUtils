package me.ddevil.util

import me.ddevil.util.math.vector.*
import java.awt.Color
import java.util.*
import java.util.concurrent.ThreadLocalRandom

@JvmOverloads
fun randomColor(random: Random = Random()): Color {
    val r = random.nextInt(256)
    val g = random.nextInt(256)
    val b = random.nextInt(256)
    return Color(r, g, b)
}

@JvmOverloads
fun randomVector2Float(scale: Float = 1.0F, random: Random = ThreadLocalRandom.current()) = FloatVector2(
        random.nextFloat() * scale,
        random.nextFloat() * scale
)

@JvmOverloads
fun randomVector3Float(scale: Float = 1.0F, random: Random = ThreadLocalRandom.current()) = FloatVector3(
        random.nextFloat() * scale,
        random.nextFloat() * scale,
        random.nextFloat() * scale
)

@JvmOverloads
fun randomVector2Double(scale: Double = 1.0, random: Random = ThreadLocalRandom.current()) = DoubleVector2(
        random.nextDouble() * scale,
        random.nextDouble() * scale
)

@JvmOverloads
fun randomVector3Double(scale: Double = 1.0, random: Random = ThreadLocalRandom.current()) = DoubleVector3(
        random.nextDouble() * scale,
        random.nextDouble() * scale,
        random.nextDouble() * scale
)

@JvmOverloads
fun randomVector2Int(bound: Int = Int.MAX_VALUE, scale: Int = 1, random: Random = ThreadLocalRandom.current()) = IntVector2(
        random.nextInt(bound) * scale,
        random.nextInt(bound) * scale
)

@JvmOverloads
fun randomVector3Int(bound: Int = Int.MAX_VALUE, scale: Int = 1, random: Random = ThreadLocalRandom.current()) = IntVector3(
        random.nextInt(bound) * scale,
        random.nextInt(bound) * scale,
        random.nextInt(bound) * scale
)

@JvmOverloads
fun randomVector2Long(scale: Long = 1, random: Random = ThreadLocalRandom.current()) = LongVector2(
        random.nextLong() * scale,
        random.nextLong() * scale
)

@JvmOverloads
fun randomVector3Long(scale: Long = 1, random: Random = ThreadLocalRandom.current()) = LongVector3(
        random.nextLong() * scale,
        random.nextLong() * scale,
        random.nextLong() * scale
)

fun <T> Array<T>.random(random: Random = ThreadLocalRandom.current()): T {
    val pos = random.nextInt(this.count())
    return this.elementAt(pos)
}

fun <T> Iterable<T>.random(random: Random = ThreadLocalRandom.current()): T {
    val pos = random.nextInt(this.count())
    return this.elementAt(pos)
}
