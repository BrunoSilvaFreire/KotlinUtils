package me.ddevil.util.vector

import me.ddevil.util.getDouble

open class DoubleVector2 : AbstractVector2<Double> {
    companion object {
        val zero = DoubleVector2(0.0, 0.0)
        val one = DoubleVector2(1.0, 1.0)
        val up = DoubleVector2(0.0, 1.0)
        val down = DoubleVector2(0.0, -1.0)
        val left = DoubleVector2(-1.0, 0.0)
        val right = DoubleVector2(1.0, 0.0)
    }

    final override var x: Double
    final override var y: Double

    constructor(map: Map<String, Any>) {
        x = map.getDouble(X_IDENTIFIER)
        y = map.getDouble(Y_IDENTIFIER)
    }

    @JvmOverloads
    constructor(x: Double = 0.0, y: Double = 0.0) : super() {
        this.x = x
        this.y = y
    }

    override fun toGeneric(value: Number) = value.toDouble()

    override val clone: Vector2<Double> get() = DoubleVector2(x, y)

    override fun toDouble() = this

    override fun plusAssignX(value: Number) {
        x += value.toDouble()
    }

    override fun plusAssignY(value: Number) {
        y += value.toDouble()
    }

    override fun minusAssignX(value: Number) {
        x -= value.toDouble()
    }

    override fun minusAssignY(value: Number) {
        y -= value.toDouble()
    }

    override fun timesAssignX(value: Number) {
        x *= value.toDouble()
    }

    override fun timesAssignY(value: Number) {
        y *= value.toDouble()
    }

    override fun divAssignX(value: Number) {
        x /= value.toDouble()
    }

    override fun divAssignY(value: Number) {
        y /= value.toDouble()
    }

}