package me.ddevil.util.math.matrix

import me.ddevil.util.math.*
import me.ddevil.util.math.vector.DoubleVector3
import me.ddevil.util.math.vector.FloatVector3
import me.ddevil.util.math.vector.Vector3f


class Quaternion
@JvmOverloads
constructor(
        var x: Float = 0F,
        var y: Float = 0F,
        var z: Float = 0F,
        var w: Float = 0F
) {
    companion object {
        fun fromEuler(pitch: Float, roll: Float, yaw: Float): Quaternion {
            val cy = cos(yaw / 2)
            val sy = sin(yaw / 2)
            val cr = cos(roll / 2)
            val sr = sin(roll / 2)
            val cp = cos(pitch / 2)
            val sp = sin(pitch / 2)
            val w = cy * cr * cp + sy * sr * sp
            val x = cy * sr * cp - sy * cr * sp
            val y = cy * cr * sp + sy * sr * cp
            val z = sy * cr * cp - cy * sr * sp
            return Quaternion(x, y, z, w)
        }
    }

    fun toEuler(): Vector3f {
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
        return FloatVector3(roll, pitch, yaw)
    }
}