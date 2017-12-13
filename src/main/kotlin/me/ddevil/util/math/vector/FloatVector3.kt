package me.ddevil.util.math.vector

import me.ddevil.util.getFloat

open class FloatVector3 : AbstractVector3<Float> {
    companion object {
        val zero = FloatVector3(0F, 0F, 0F)
        val one = FloatVector3(1F, 1F, 1F)
        val up = FloatVector3(0F, 1F, 0F)
        val down = FloatVector3(0F, -1F, 0F)
        val left = FloatVector3(-1F, 0F, 0F)
        val right = FloatVector3(1F, 0F, 0F)
        val forward = FloatVector3(0F, 0F, 1F)
        val back = FloatVector3(0F, 0F, -1F)
    }

    final override var x: Float
    final override var y: Float
    final override var z: Float

    constructor(map: Map<String, Any>) {
        x = map.getFloat(X_IDENTIFIER)
        y = map.getFloat(Y_IDENTIFIER)
        z = map.getFloat(Z_IDENTIFIER)
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
