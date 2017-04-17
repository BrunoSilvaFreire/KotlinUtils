package me.ddevil.util.vector

import me.ddevil.util.getOrException

open class FloatVector3 : AbstractVector3<Float> {
    final override var x: Float
    final override var y: Float
    final override var z: Float

    constructor(map: Map<String, Any>) {
        x = map.getOrException<Number>(X_IDENTIFIER).toFloat()
        y = map.getOrException<Number>(Y_IDENTIFIER).toFloat()
        z = map.getOrException<Number>(Z_IDENTIFIER).toFloat()
    }

    @JvmOverloads
    constructor(x: Float = 0.0F, y: Float = 0.0F, z: Float = 0.0F) : super() {
        this.x = x
        this.y = y
        this.z = z
    }

    override fun toFloat(): Vector3<Float> = this

    override fun plusAssignX(value: Number) {
        x += value.toFloat()
    }

    override fun plusAssignY(value: Number) {
        y += value.toFloat()
    }

    override fun plusAssignZ(value: Number) {
        z += value.toFloat()
    }

    override fun minusAssignX(value: Number) {
        x -= value.toFloat()
    }

    override fun minusAssignY(value: Number) {
        y -= value.toFloat()
    }

    override fun minusAssignZ(value: Number) {
        z -= value.toFloat()
    }

    override fun timesAssignX(value: Number) {
        x *= value.toFloat()
    }

    override fun timesAssignY(value: Number) {
        y *= value.toFloat()
    }

    override fun timesAssignZ(value: Number) {
        z *= value.toFloat()
    }

    override fun divAssignX(value: Number) {
        x /= value.toFloat()
    }

    override fun divAssignY(value: Number) {
        y /= value.toFloat()
    }

    override fun divAssignZ(value: Number) {
        z /= value.toFloat()
    }

    override fun toGeneric(value: Number) = value.toFloat()

    override val clone get() = FloatVector3(x, y, z)
}
