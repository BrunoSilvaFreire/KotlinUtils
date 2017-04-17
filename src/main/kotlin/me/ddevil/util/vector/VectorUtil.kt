package me.ddevil.util.vector

const val X_IDENTIFIER = "x"

const val Y_IDENTIFIER = "y"

const val Z_IDENTIFIER = "z"

fun <N : Number> Vector2<N>.clampMagnitude(max: Double, min: Double): Vector2<N> {
    if (magnitude > max) {
        magnitude = max
    }
    if (magnitude < min) {
        magnitude = min
    }
    return this
}

fun <N : Number> Vector2<N>.clampMagnitude01() = clampMagnitude(0.0, 1.0)
