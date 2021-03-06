package me.ddevil.util.math.vector

import me.ddevil.util.getInt

open class IntVector3 : Vector3<Int> {

    companion object {
        val zero = IntVector3(0, 0, 0)
        val one = IntVector3(1, 1, 1)
        val up = IntVector3(0, 1, 0)
        val down = IntVector3(0, -1, 0)
        val left = IntVector3(-1, 0, 0)
        val right = IntVector3(1, 0, 0)
        val forward = IntVector3(0, 0, 1)
        val back = IntVector3(0, 0, -1)
    }

    final override var x: Int
    final override var y: Int
    final override var z: Int

    constructor(map: Map<String, Any>) {
        x = map.getInt(X_IDENTIFIER)
        y = map.getInt(Y_IDENTIFIER)
        z = map.getInt(Z_IDENTIFIER)
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

    override fun toString() = "IntVector3(x=$x, y=$y, z=$z)"

}