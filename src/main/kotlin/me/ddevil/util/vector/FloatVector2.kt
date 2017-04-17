package me.ddevil.util.vector

import me.ddevil.util.getOrException

open class FloatVector2 : AbstractVector2<Float> {

    final override var x: Float
    final override var y: Float

    constructor(map: Map<String, Any>) {
        x = map.getOrException<Number>(X_IDENTIFIER).toFloat()
        y = map.getOrException<Number>(Y_IDENTIFIER).toFloat()
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

