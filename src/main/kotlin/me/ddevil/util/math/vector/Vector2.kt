package me.ddevil.util.math.vector

import com.google.common.collect.ImmutableMap
import me.ddevil.util.Serializable
import me.ddevil.util.square

abstract class Vector2<N : Number> : Serializable {
    abstract val x: N
    abstract val y: N
    //Delegates
    protected abstract fun plusAssignX(value: Number)

    protected abstract fun plusAssignY(value: Number)


    protected abstract fun minusAssignX(value: Number)

    protected abstract fun minusAssignY(value: Number)


    protected abstract fun timesAssignX(value: Number)

    protected abstract fun timesAssignY(value: Number)


    protected abstract fun divAssignX(value: Number)

    protected abstract fun divAssignY(value: Number)

    protected abstract fun toGeneric(value: Number): N


    override fun serialize(): Map<String, Any> = ImmutableMap.builder<String, Any>()
            .put(X_IDENTIFIER, x)
            .put(Y_IDENTIFIER, y)
            .build()

    open fun toInt(): Vector2<Int> = IntVector2(x.toInt(), y.toInt())

    open fun toFloat(): Vector2<Float> = FloatVector2(x.toFloat(), y.toFloat())

    open fun toLong(): Vector2<Long> = LongVector2(x.toLong(), y.toLong())

    open fun toDouble(): Vector2<Double> = DoubleVector2(x.toDouble(), y.toDouble())

    abstract val clone: Vector2<N>

    open val normalized: Vector2<N>
        get() = clone.normalize()

    var magnitude: Double
        get() = Math.sqrt(x.square().toDouble() + y.square().toDouble())
        set(value) {
            this /= magnitude / value
        }

    open fun distance(other: Vector2<*>) = (other - this).magnitude

    fun compareTo(other: Vector2<*>): Int {
        if (this === other || this == other) {
            return 0
        }
        return magnitude.compareTo(other.magnitude)
    }

    open fun normalize(): Vector2<N> {
        val mag = toGeneric(magnitude)
        this /= mag
        return this
    }


    operator fun plusAssign(other: Vector2<*>) {
        plusAssignX(other.x)
        plusAssignY(other.y)
    }


    operator fun plus(other: Vector2<*>): Vector2<N> {
        val clone = this.clone
        clone += other
        return clone
    }

    operator fun minusAssign(other: Vector2<*>) {
        minusAssignX(other.x)
        minusAssignY(other.y)
    }


    operator fun minus(other: Vector2<*>): Vector2<N> {
        val clone = this.clone
        clone -= other
        return clone
    }

    operator fun timesAssign(other: Vector2<*>) {
        timesAssignX(other.x)
        timesAssignY(other.y)
    }


    operator fun times(other: Vector2<*>): Vector2<N> {
        val clone = this.clone
        clone *= other
        return clone
    }

    operator fun divAssign(other: Vector2<*>) {
        divAssignX(other.x)
        divAssignY(other.y)
    }

    operator fun div(other: Vector2<*>): Vector2<N> {
        val clone = this.clone
        clone /= other
        return clone
    }

    open operator fun plusAssign(value: Number) {
        plusAssignX(value)
        plusAssignY(value)
    }


    open operator fun plus(value: Number): Vector2<N> {
        val clone = this.clone
        clone += value
        return clone
    }

    open operator fun minusAssign(value: Number) {
        minusAssignX(value)
        minusAssignY(value)
    }

    open operator fun minus(value: Number): Vector2<N> {
        val clone = this.clone
        clone -= value
        return clone
    }

    open operator fun timesAssign(value: Number) {
        timesAssignX(value)
        timesAssignY(value)
    }

    open operator fun times(value: Number): Vector2<N> {
        val clone = this.clone
        clone *= value
        return clone
    }

    open operator fun divAssign(value: Number) {
        divAssignX(value)
        divAssignY(value)
    }

    open operator fun div(value: Number): Vector2<N> {
        val clone = this.clone
        clone /= value
        return clone
    }
}

