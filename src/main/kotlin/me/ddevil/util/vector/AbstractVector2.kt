package me.ddevil.util.vector

import com.google.common.collect.ImmutableMap
import me.ddevil.util.square

abstract class AbstractVector2<N : Number> : Vector2<N> {

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

    override fun toInt(): Vector2<Int> = IntVector2(x.toInt(), y.toInt())

    override fun toFloat(): Vector2<Float> = FloatVector2(x.toFloat(), y.toFloat())

    override fun toLong(): Vector2<Long> = LongVector2(x.toLong(), y.toLong())

    override fun toDouble(): Vector2<Double> = DoubleVector2(x.toDouble(), y.toDouble())


    override val normalized: Vector2<N>
        get() = clone.normalize()

    override var magnitude: Double
        get() = Math.sqrt(x.square().toDouble() + y.square().toDouble())
        set(value) {
            this /= magnitude / value
        }

    override fun distance(other: Vector2<*>) = (other - this).magnitude

    override fun compareTo(other: Vector2<*>): Int {
        if (this === other || this == other) {
            return 0
        }
        return magnitude.compareTo(other.magnitude)
    }

    override fun normalize(): Vector2<N> {
        val mag = toGeneric(magnitude)
        this /= mag
        return this
    }


    override fun plusAssign(other: Vector2<*>) {
        plusAssignX(other.x)
        plusAssignY(other.y)
    }


    override fun plus(other: Vector2<*>): Vector2<N> {
        val clone = this.clone
        clone += other
        return clone
    }

    override fun minusAssign(other: Vector2<*>) {
        minusAssignX(other.x)
        minusAssignY(other.y)
    }


    override fun minus(other: Vector2<*>): Vector2<N> {
        val clone = this.clone
        clone -= other
        return clone
    }

    override fun timesAssign(other: Vector2<*>) {
        timesAssignX(other.x)
        timesAssignY(other.y)
    }


    override fun times(other: Vector2<*>): Vector2<N> {
        val clone = this.clone
        clone *= other
        return clone
    }

    override fun divAssign(other: Vector2<*>) {
        divAssignX(other.x)
        divAssignY(other.y)
    }

    override fun div(other: Vector2<*>): Vector2<N> {
        val clone = this.clone
        clone /= other
        return clone
    }

    override fun plusAssign(value: Number) {
        plusAssignX(value)
        plusAssignY(value)
    }


    override fun plus(value: Number): Vector2<N> {
        val clone = this.clone
        clone += value
        return clone
    }

    override fun minusAssign(value: Number) {
        minusAssignX(value)
        minusAssignY(value)
    }

    override fun minus(value: Number): Vector2<N> {
        val clone = this.clone
        clone -= value
        return clone
    }

    override fun timesAssign(value: Number) {
        timesAssignX(value)
        timesAssignY(value)
    }

    override fun times(value: Number): Vector2<N> {
        val clone = this.clone
        clone *= value
        return clone
    }

    override fun divAssign(value: Number) {
        divAssignX(value)
        divAssignY(value)
    }

    override fun div(value: Number): Vector2<N> {
        val clone = this.clone
        clone /= value
        return clone
    }
}

