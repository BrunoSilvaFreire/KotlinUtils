package me.ddevil.util.vector

import me.ddevil.util.getOrException

open class LongVector3 : AbstractVector3<Long> {

    final override var x: Long
    final override var y: Long
    final override var z: Long

    constructor(map: Map<String, Any>) {
        x = map.getOrException<Number>(X_IDENTIFIER).toLong()
        y = map.getOrException<Number>(Y_IDENTIFIER).toLong()
        z = map.getOrException<Number>(Z_IDENTIFIER).toLong()
    }

    @JvmOverloads
    constructor(x: Long = 0, y: Long = 0, z: Long = 0) {
        this.x = x
        this.y = y
        this.z = z
    }

    override fun toLong(): Vector3<Long> = this
    override fun plusAssignX(value: Number) {
        x += value.toLong()
    }

    override fun plusAssignY(value: Number) {
        y += value.toLong()
    }

    override fun plusAssignZ(value: Number) {
        z += value.toLong()
    }

    override fun minusAssignX(value: Number) {
        x -= value.toLong()
    }

    override fun minusAssignY(value: Number) {
        y -= value.toLong()
    }

    override fun minusAssignZ(value: Number) {
        z -= value.toLong()
    }

    override fun timesAssignX(value: Number) {
        x *= value.toLong()
    }

    override fun timesAssignY(value: Number) {
        y *= value.toLong()
    }

    override fun timesAssignZ(value: Number) {
        z *= value.toLong()
    }

    override fun divAssignX(value: Number) {
        x /= value.toLong()
    }

    override fun divAssignY(value: Number) {
        y /= value.toLong()
    }

    override fun divAssignZ(value: Number) {
        z /= value.toLong()
    }

    override fun toGeneric(value: Number) = value.toLong()

    override val clone: Vector3<Long> get() = LongVector3(x, y, z)
}