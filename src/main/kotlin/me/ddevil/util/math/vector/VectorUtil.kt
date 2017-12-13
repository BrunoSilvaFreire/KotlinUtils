package me.ddevil.util.math.vector

const val X_IDENTIFIER = "x"

const val Y_IDENTIFIER = "y"

const val Z_IDENTIFIER = "z"

const val W_IDENTIFIER = "w"
typealias Vector2f = FloatVector2
typealias Vector2d = DoubleVector2
typealias Vector2i = IntVector2
typealias Vector2l = LongVector2

typealias Vector3f = FloatVector3
typealias Vector3d = DoubleVector3
typealias Vector3i = IntVector3
typealias Vector3l = LongVector3

typealias Vector4f = FloatVector4
typealias Vector4d = DoubleVector4
typealias Vector4i = IntVector4
typealias Vector4l = LongVector4

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