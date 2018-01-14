package me.ddevil.util.math.quaternion

import me.ddevil.util.math.*
import me.ddevil.util.math.matrix.Matrix4
import me.ddevil.util.math.vector.Vector3f


data class Quaternion
@JvmOverloads
constructor(
        var x: Float = 0F,
        var y: Float = 0F,
        var z: Float = 0F,
        var w: Float = 1F
) {
    companion object {
        val identity = Quaternion()
        fun fromEulerAngle(x: Float, y: Float, z: Float): Quaternion {
            return fromEulerAngle(Vector3f(x, y, z))
        }

        fun fromEulerAngle(angle: Vector3f): Quaternion {
            val q = Quaternion()
            q.eulerAngle = angle
            return q
        }

        fun fromAxisAngle(axis: Vector3f, angle: Float): Quaternion {
            return fromAxisAngle(axis.x, axis.y, axis.z, angle)
        }

        fun fromAxisAngle(ax: Float, ay: Float, az: Float, angle: Float): Quaternion {
            // w = cos(tetha / 2)
            // (x,y,z) = v = sin(tetha / 2) * r
            val qx = ax * sin(angle / 2)
            val qy = ay * sin(angle / 2)
            val qz = az * sin(angle / 2)
            val qw = cos(angle / 2)
            return Quaternion(qx, qy, qz, qw)
        }
    }

    val inverted get() = Quaternion(-x, -y, -z, w)

    var eulerAngle: Vector3f
        get() {
            val sinr = 2F * (w * x + y * z)
            val cosr = 1F - 2F * (x * x + y * y)
            val roll = atan2(sinr, cosr)

            val sinp = 2F * (w * y - z * x)
            val pitch = if (fabs(sinp) >= 1) {
                copysign(PI / 2, sinp)
            } else {
                asin(sinp)
            }

            val siny = 2F * (w * z + x * y)
            val cosy = 1F - 2F * (y * y + z * z)
            val yaw = atan2(siny, cosy)
            return Vector3f(roll, pitch, yaw)
        }
        set(value) {
            val pitch = value.x
            val roll = value.y
            val yaw = value.z
            val cy = cos(yaw / 2)
            val sy = sin(yaw / 2)
            val cr = cos(roll / 2)
            val sr = sin(roll / 2)
            val cp = cos(pitch / 2)
            val sp = sin(pitch / 2)
            w = cy * cr * cp + sy * sr * sp
            x = cy * sr * cp - sy * cr * sp
            y = cy * cr * sp + sy * sr * cp
            z = sy * cr * cp - cy * sr * sp
        }


    fun toMatrix(destination: Matrix4) {
        val xx = x * x
        val xy = x * y
        val xz = x * z
        val xw = x * w
        val yy = y * y
        val yz = y * z
        val yw = y * w
        val zz = z * z
        val zw = z * w
        destination.m00 = 1 - 2 * (yy + zz)
        destination.m01 = 2 * (xy - zw)
        destination.m02 = 2 * (xz + yw)
        destination.m03 = 0f
        destination.m10 = 2 * (xy + zw)
        destination.m11 = 1 - 2 * (xx + zz)
        destination.m12 = 2 * (yz - xw)
        destination.m13 = 0f
        destination.m20 = 2 * (xz - yw)
        destination.m21 = 2 * (yz + xw)
        destination.m22 = 1 - 2 * (xx + yy)
        destination.m23 = 0f
        destination.m30 = 0f
        destination.m31 = 0f
        destination.m32 = 0f
        destination.m33 = 1f
    }

    fun toMatrix(): Matrix4 {
        val matrix = Matrix4()
        toMatrix(matrix)
        return matrix
    }
}