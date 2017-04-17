package me.ddevil.util.vector

import me.ddevil.util.getOrException

open class IntVector3 : AbstractVector3<Int> {

    final override var x: Int
    final override var y: Int
    final override var z: Int

    constructor(map: Map<String, Any>) {
        x = map.getOrException<Number>(X_IDENTIFIER).toInt()
        y = map.getOrException<Number>(Y_IDENTIFIER).toInt()
        z = map.getOrException<Number>(Z_IDENTIFIER).toInt()
    }

    @JvmOverloads
    constructor(x: Int = 0, y: Int = 0, z: Int = 0) {
        this.x = x
        this.y = y
        this.z = z
    }


    override fun toInt(): Vector3<Int> = this

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

    override fun toGeneric(value: Number) = value.toInt()

    override val clone: Vector3<Int> get() = IntVector3(x, y, z)
}