package me.ddevil.util.math.matrix

import java.io.Serializable

data class Matrix4
@JvmOverloads
constructor(
        var m00: Float = 0F,
        var m01: Float = 0F,
        var m02: Float = 0F,
        var m03: Float = 0F,
        var m10: Float = 0F,
        var m11: Float = 0F,
        var m12: Float = 0F,
        var m13: Float = 0F,
        var m20: Float = 0F,
        var m21: Float = 0F,
        var m22: Float = 0F,
        var m23: Float = 0F,
        var m30: Float = 0F,
        var m31: Float = 0F,
        var m32: Float = 0F,
        var m33: Float = 0F
) : Serializable {
    companion object {

        val zero = Matrix4()

        val identity = Matrix4(
                m00 = 1F,
                m11 = 1F,
                m22 = 1F,
                m33 = 1F
        )
    }

    fun determinant(): Float {
        return (m30 * m21 * m12 * m00) - (m20 * m31 * m12 * m00) - (m30 * m11 * m22 * m03) + (m00 * m21 * m12 * m03) +
                (m20 * m11 * m32 * m03) - (m10 * m21 * m32 * m03) - (m30 * m21 * m02 * m13) + (m20 * m31 * m02 * m13) +
                (m30 * m01 * m22 * m13) - (m00 * m31 * m22 * m13) - (m20 * m01 * m32 * m13) + (m00 * m21 * m32 * m13) +
                (m30 * m11 * m02 * m23) - (m10 * m31 * m02 * m23) - (m30 * m01 * m12 * m23) + (m00 * m31 * m12 * m23) +
                (m10 * m01 * m32 * m23) - (m00 * m11 * m32 * m23) - (m20 * m11 * m02 * m33) + (m10 * m21 * m02 * m33) +
                (m20 * m01 * m12 * m33) - (m00 * m21 * m12 * m33) - (m10 * m01 * m22 * m33) + (m00 * m11 * m20 * m33)
    }

}