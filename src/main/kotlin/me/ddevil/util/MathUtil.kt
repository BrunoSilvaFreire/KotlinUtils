package me.ddevil.util

fun Int.square() = this * this

fun Long.square() = this * this

fun Float.square() = this * this

fun Double.square() = this * this

fun Number.square(): Number {
    when (this) {
        is Int -> return this.square()
        is Long -> return this.square()
        is Float -> return this.square()
        is Double -> return this.square()
        else -> throw IllegalArgumentException("Invalid number type! ${this::class.java.name}")
    }
}

fun lerp(a: Float, b: Float, alpha: Float) = a + alpha * (b - a)

fun Double.radToDegrees() = Math.toDegrees(this)

fun Double.degreesToRad() = Math.toRadians(this)


fun Float.clamp(min: Float, max: Float): Float {
    if (this > max) {
        return max
    }
    if (this < min) {
        return min
    }
    return this
}

fun Double.clamp(max: Double, min: Double): Double {
    if (this > max) {
        return max
    }
    if (this < min) {
        return min
    }
    return this
}

fun Float.clamp01() = clamp(0.0F, 1.0F)

fun Double.clamp01() = clamp(0.0, 1.0)