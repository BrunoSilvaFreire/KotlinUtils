package me.ddevil.util.math.vector

import me.ddevil.util.getDouble
import kotlin.math.sqrt

open class DoubleVector4 : AbstractVector4<Double> {


    final override var x: Double
    final override var y: Double
    final override var z: Double
    final override var w: Double

    constructor(map: Map<String, Any>) {
        x = map.getDouble(X_IDENTIFIER)
        y = map.getDouble(Y_IDENTIFIER)
        z = map.getDouble(Z_IDENTIFIER)
        w = map.getDouble(W_IDENTIFIER)
    }

    @JvmOverloads
    constructor(x: Double = 0.0, y: Double = 0.0, z: Double = 0.0, w: Double = 0.0) : super() {
        this.x = x
        this.y = y
        this.z = z
        this.w = w
    }

    override fun distance(other: Vector4<*>): Double {
        return sqrt(x * other.x.toDouble() + y * other.y.toDouble() + z * other.z.toDouble() + w * other.w.toDouble())
    }

    override val clone: Vector4<Double> get() = DoubleVector4(x, y, z, w)

    override fun toDouble(): Vector4<Double> = this

    override fun plusAssignX(value: Number) {
        x += value.toDouble()
    }

    override fun plusAssignY(value: Number) {
        y += value.toDouble()
    }

    override fun plusAssignZ(value: Number) {
        z += value.toDouble()
    }

    override fun minusAssignX(value: Number) {
        x -= value.toDouble()
    }

    override fun minusAssignY(value: Number) {
        y -= value.toDouble()
    }

    override fun minusAssignZ(value: Number) {
        z -= value.toDouble()
    }

    override fun timesAssignX(value: Number) {
        x *= value.toDouble()
    }

    override fun timesAssignY(value: Number) {
        y *= value.toDouble()
    }

    override fun timesAssignZ(value: Number) {
        z *= value.toDouble()
    }

    override fun divAssignX(value: Number) {
        x /= value.toDouble()
    }

    override fun divAssignY(value: Number) {
        y /= value.toDouble()
    }

    override fun divAssignZ(value: Number) {
        z /= value.toDouble()
    }

    override fun plusAssignW(value: Number) {
        w += value.toDouble()
    }

    override fun minusAssignW(value: Number) {
        w -= value.toDouble()
    }

    override fun timesAssignW(value: Number) {
        w *= value.toDouble()
    }

    override fun divAssignW(value: Number) {
        w /= value.toDouble()
    }

    override fun toGeneric(value: Number) = value.toDouble()

}