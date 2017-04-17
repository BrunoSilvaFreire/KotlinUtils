package me.ddevil.util.vector

import me.ddevil.util.getOrException

open class LongVector2 : AbstractVector2<Long> {

    final override var x: Long
    final override var y: Long

    constructor(map: Map<String, Any>) {
        x = map.getOrException<Number>(X_IDENTIFIER).toLong()
        y = map.getOrException<Number>(Y_IDENTIFIER).toLong()
    }
    @JvmOverloads
    constructor(x: Long = 0, y: Long = 0) : super() {
        this.x = x
        this.y = y
    }

    override val clone: Vector2<Long> get() = LongVector2(x, y)

    override fun toGeneric(value: Number) = value.toLong()

    override fun toLong() = this

    override fun plusAssignX(value: Number) {
        x += value.toLong()
    }

    override fun plusAssignY(value: Number) {
        y += value.toLong()
    }

    override fun minusAssignX(value: Number) {
        x -= value.toLong()
    }

    override fun minusAssignY(value: Number) {
        y -= value.toLong()
    }

    override fun timesAssignX(value: Number) {
        x *= value.toLong()
    }

    override fun timesAssignY(value: Number) {
        y *= value.toLong()
    }

    override fun divAssignX(value: Number) {
        x /= value.toLong()
    }

    override fun divAssignY(value: Number) {
        y /= value.toLong()
    }
}