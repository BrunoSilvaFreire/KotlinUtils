package me.ddevil.util.vector

import me.ddevil.util.getOrException

open class DoubleVector3 : AbstractVector3<Double> {

    final override var x: Double
    final override var y: Double
    final override var z: Double

    constructor(map: Map<String, Any>) {
        x = map.getOrException<Number>(X_IDENTIFIER).toDouble()
        y = map.getOrException<Number>(Y_IDENTIFIER).toDouble()
        z = map.getOrException<Number>(Z_IDENTIFIER).toDouble()
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
