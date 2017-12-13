package me.ddevil.util.math.vector

import me.ddevil.util.getFloat

open class FloatVector2 : AbstractVector2<Float> {
    companion object {
        val zero = FloatVector2(0.0F, 0.0F)
        val one = FloatVector2(1F, 1F)
        val up = FloatVector2(0.0F, 1F)
        val down = FloatVector2(0.0F, -1F)
        val left = FloatVector2(-1F, 0.0F)
        val right = FloatVector2(1F, 0.0F)
    }

    final override var x: Float
    final override var y: Float

    constructor(map: Map<String, Any>) {
        x = map.getFloat(X_IDENTIFIER)
        y = map.getFloat(Y_IDENTIFIER)
    }

    @JvmOverloads
    constructor(x: Float = 0.0F, y: Float = 0.0F) {
        this.x = x
        this.y = y
    }

    override val clone get() = FloatVector2(x, y)

    override fun toGeneric(value: Number) = value.toFloat()

    override fun toFloat() = this

    override fun plusAssignX(value: Number) {
        x += value.toFloat()
    }


    override fun plusAssignY(value: Number) {
        y += value.toFloat()
    }

    override fun minusAssignX(value: Number) {
        x -= value.toFloat()
    }

    override fun minusAssignY(value: Number) {
        y -= value.toFloat()
    }

    override fun timesAssignX(value: Number) {
        x *= value.toFloat()
    }

    override fun timesAssignY(value: Number) {
        y *= value.toFloat()
    }


    override fun divAssignX(value: Number) {
        x /= value.toFloat()
    }


    override fun divAssignY(value: Number) {
        y /= value.toFloat()
    }

}

