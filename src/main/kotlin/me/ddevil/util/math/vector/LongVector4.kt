package me.ddevil.util.math.vector

import me.ddevil.util.getLong
import kotlin.math.sqrt

open class LongVector4 : Vector4<Long> {


    final override var x: Long
    final override var y: Long
    final override var z: Long
    final override var w: Long

    constructor(map: Map<String, Any>) {
        x = map.getLong(X_IDENTIFIER)
        y = map.getLong(Y_IDENTIFIER)
        z = map.getLong(Z_IDENTIFIER)
        w = map.getLong(W_IDENTIFIER)
    }

    @JvmOverloads
    constructor(x: Long = 0, y: Long = 0, z: Long = 0, w: Long = 0) : super() {
        this.x = x
        this.y = y
        this.z = z
        this.w = w
    }

    override val clone: Vector4<Long> get() = LongVector4(x, y, z, w)

    override fun toLong(): Vector4<Long> = this

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

    override fun plusAssignW(value: Number) {
        w += value.toLong()
    }

    override fun minusAssignW(value: Number) {
        w -= value.toLong()
    }

    override fun timesAssignW(value: Number) {
        w *= value.toLong()
    }

    override fun divAssignW(value: Number) {
        w /= value.toLong()
    }

    override fun toGeneric(value: Number) = value.toLong()

}