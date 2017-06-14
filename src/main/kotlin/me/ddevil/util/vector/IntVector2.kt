package me.ddevil.util.vector

import me.ddevil.util.getInt

open class IntVector2 : AbstractVector2<Int> {

    final override var x: Int
    final override var y: Int

    constructor(map: Map<String, Any>) {
        x = map.getInt(X_IDENTIFIER)
        y = map.getInt(Y_IDENTIFIER)
    }

    @JvmOverloads
    constructor(x: Int = 0, y: Int = 0) : super() {
        this.x = x
        this.y = y
    }

    override val clone: Vector2<Int> get() = IntVector2(x, y)

    override fun toGeneric(value: Number) = value.toInt()

    override fun toInt() = this

    override fun plusAssignX(value: Number) {
        x += value.toInt()
    }

    override fun plusAssignY(value: Number) {
        y += value.toInt()
    }

    override fun minusAssignX(value: Number) {
        x -= value.toInt()
    }

    override fun minusAssignY(value: Number) {
        y -= value.toInt()
    }

    override fun timesAssignX(value: Number) {
        x *= value.toInt()
    }

    override fun timesAssignY(value: Number) {
        y *= value.toInt()
    }


    override fun divAssignY(value: Number) {
        y /= value.toInt()
    }

    override fun divAssignX(value: Number) {
        x /= value.toInt()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other !is IntVector2) {
            return false
        }
        return x == other.x && y == other.y
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }

}