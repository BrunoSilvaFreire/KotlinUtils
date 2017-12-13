package me.ddevil.util.math.vector

import me.ddevil.util.getDouble

open class DoubleVector3 : Vector3<Double> {

    companion object {
        val zero = DoubleVector3(0.0, 0.0, 0.0)
        val one = DoubleVector3(1.0, 1.0, 1.0)
        val up = DoubleVector3(0.0, 1.0, 0.0)
        val down = DoubleVector3(0.0, -1.0, 0.0)
        val left = DoubleVector3(-1.0, 0.0, 0.0)
        val right = DoubleVector3(1.0, 0.0, 0.0)
        val forward = DoubleVector3(0.0, 0.0, 1.0)
        val back = DoubleVector3(0.0, 0.0, -1.0)
    }

    final override var x: Double
    final override var y: Double
    final override var z: Double

    constructor(map: Map<String, Any>) {
        x = map.getDouble(X_IDENTIFIER)
        y = map.getDouble(Y_IDENTIFIER)
        z = map.getDouble(Z_IDENTIFIER)
    }

    @JvmOverloads
    constructor(x: Double = 0.0, y: Double = 0.0, z: Double = 0.0) : super() {
        this.x = x
        this.y = y
        this.z = z
    }

    override val clone: Vector3<Double> get() = DoubleVector3(x, y, z)

    override fun toDouble(): Vector3<Double> = this

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

    override fun toGeneric(value: Number) = value.toDouble()

}
