package me.ddevil.util.math.vector

import me.ddevil.util.getInt
import kotlin.math.sqrt

open class IntVector4 : AbstractVector4<Int> {


    final override var x: Int
    final override var y: Int
    final override var z: Int
    final override var w: Int
    constructor(map: Map<String, Any>) {
        x = map.getInt(X_IDENTIFIER)
        y = map.getInt(Y_IDENTIFIER)
        z = map.getInt(Z_IDENTIFIER)
        w = map.getInt(W_IDENTIFIER)
    }
    @JvmOverloads
    constructor(x: Int = 0, y: Int = 0, z: Int = 0, w: Int = 0) : super() {
        this.x = x
        this.y = y
        this.z = z
        this.w = w
    }

    override fun distance(other: Vector4<*>): Double {
        return sqrt(x * other.x.toDouble() + y * other.y.toDouble() + z * other.z.toDouble() + w * other.w.toDouble())
    }

    override val clone: Vector4<Int> get() = IntVector4(x, y, z, w)

    override fun toInt(): Vector4<Int> = this

    override fun plusAssignX(value: Number) {
        x += value.toInt()
    }

    override fun plusAssignY(value: Number) {
        y += value.toInt()
    }

    override fun plusAssignZ(value: Number) {
        z += value.toInt()
    }

    override fun minusAssignX(value: Number) {
        x -= value.toInt()
    }

    override fun minusAssignY(value: Number) {
        y -= value.toInt()
    }

    override fun minusAssignZ(value: Number) {
        z -= value.toInt()
    }

    override fun timesAssignX(value: Number) {
        x *= value.toInt()
    }

    override fun timesAssignY(value: Number) {
        y *= value.toInt()
    }

    override fun timesAssignZ(value: Number) {
        z *= value.toInt()
    }

    override fun divAssignX(value: Number) {
        x /= value.toInt()
    }

    override fun divAssignY(value: Number) {
        y /= value.toInt()
    }

    override fun divAssignZ(value: Number) {
        z /= value.toInt()
    }

    override fun plusAssignW(value: Number) {
        w += value.toInt()
    }

    override fun minusAssignW(value: Number) {
        w -= value.toInt()
    }

    override fun timesAssignW(value: Number) {
        w *= value.toInt()
    }

    override fun divAssignW(value: Number) {
        w /= value.toInt()
    }

    override fun toGeneric(value: Number) = value.toInt()

}