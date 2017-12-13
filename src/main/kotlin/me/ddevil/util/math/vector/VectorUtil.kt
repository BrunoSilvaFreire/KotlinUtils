package me.ddevil.util.math.vector

const val X_IDENTIFIER = "x"

const val Y_IDENTIFIER = "y"

const val Z_IDENTIFIER = "z"

const val W_IDENTIFIER = "w"

typealias Vector2f = Vector2<Float>
typealias Vector2d = Vector2<Double>
typealias Vector2i = Vector2<Int>
typealias Vector2l = Vector2<Long>
typealias Vector3f = Vector3<Float>
typealias Vector3d = Vector3<Double>
typealias Vector3i = Vector3<Int>
typealias Vector3l = Vector3<Long>
typealias Vector4f = Vector4<Float>
typealias Vector4d = Vector4<Double>
typealias Vector4i = Vector4<Int>
typealias Vector4l = Vector4<Long>

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