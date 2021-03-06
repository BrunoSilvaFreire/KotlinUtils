package me.ddevil.util.math.vector

import me.ddevil.util.getLong

open class LongVector3 : Vector3<Long> {
    companion object {
        val zero = LongVector3(0L, 0L, 0L)
        val one = LongVector3(1L, 1L, 1L)
        val up = LongVector3(0L, 1L, 0L)
        val down = LongVector3(0L, -1L, 0L)
        val left = LongVector3(-1L, 0L, 0L)
        val right = LongVector3(1L, 0L, 0L)
        val forward = LongVector3(0L, 0L, 1L)
        val back = LongVector3(0L, 0L, -1L)
    }

    final override var x: Long
    final override var y: Long
    final override var z: Long

    constructor(map: Map<String, Any>) {
        x = map.getLong(X_IDENTIFIER)
        y = map.getLong(Y_IDENTIFIER)
        z = map.getLong(Z_IDENTIFIER)
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