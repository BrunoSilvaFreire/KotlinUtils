package me.ddevil.util.vector

const val X_IDENTIFIER = "x"

const val Y_IDENTIFIER = "y"

const val Z_IDENTIFIER = "z"

const val W_IDENTIFIER = "w"

fun <V : Vector2<N>, N : Number> V.clampMagnitude(max: Double, min: Double): V {
    if (magnitude > max) {
        magnitude = max
    }
    if (magnitude < min) {
        magnitude = min
    }
    return this
}

fun <V : Vector2<N>, N : Number> V.clampMagnitude01() = clampMagnitude(0.0, 1.0)