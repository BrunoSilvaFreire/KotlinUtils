package me.ddevil.util.math.vector

import me.ddevil.util.immutableMap
import me.ddevil.util.set

abstract class Vector4<N : Number> : Vector3<N>() {
    abstract val w: N

    override val normalized: Vector4<N>
        get() = clone.normalize()

    override fun normalize(): Vector4<N> {
        super.normalize()
        return this
    }

    abstract override val clone: Vector4<N>

    override fun serialize(): Map<String, Any> = immutableMap {
        putAll(super.serialize())
        this[W_IDENTIFIER] = w
    }

    fun distance(other: Vector4<*>) = (other - this).magnitude

    protected abstract fun plusAssignW(value: Number)


    protected abstract fun minusAssignW(value: Number)


    protected abstract fun timesAssignW(value: Number)

    protected abstract fun divAssignW(value: Number)


    override fun toInt(): Vector4<Int> = IntVector4(x.toInt(), z.toInt(), y.toInt(), w.toInt())

    override fun toFloat(): Vector4<Float> = FloatVector4(x.toFloat(), y.toFloat(), z.toFloat(), w.toFloat())

    override fun toLong(): Vector4<Long> = LongVector4(x.toLong(), y.toLong(), z.toLong(), w.toLong())

    override fun toDouble(): Vector4<Double> = DoubleVector4(x.toDouble(), y.toDouble(), z.toDouble(), w.toDouble())


    fun plusAssign(other: Vector4<*>) {
        super.plusAssign(other)
        plusAssignW(other.w)
    }


    fun minusAssign(other: Vector4<*>) {
        super.minusAssign(other)
        minusAssignW(other.w)
    }


    fun timesAssign(other: Vector4<*>) {
        super.timesAssign(other)
        timesAssignW(other.w)
    }


    fun divAssign(other: Vector4<*>) {
        super.divAssign(other)
        divAssignW(other.w)
    }

    override fun plusAssign(value: Number) {
        super.plus(value)
        plusAssignW(value)
    }


    override fun minusAssign(value: Number) {
        super.minusAssign(value)
        minusAssignW(value)
    }


    override fun timesAssign(value: Number) {
        super.timesAssign(value)
        timesAssignW(value)
    }


    override fun divAssign(value: Number) {
        super.divAssign(value)
        divAssignW(value)
    }

    fun plus(other: Vector4<*>): Vector4<N> {
        val clone = this.clone
        clone += other
        return clone
    }

    fun minus(other: Vector4<*>): Vector4<N> {
        val clone = this.clone
        clone -= other
        return clone
    }

    fun times(other: Vector4<*>): Vector4<N> {
        val clone = this.clone
        clone *= other
        return clone
    }

    fun div(other: Vector4<*>): Vector4<N> {
        val clone = this.clone
        clone /= other
        return clone
    }

    override fun plus(value: Number): Vector4<N> {
        val clone = this.clone
        clone += value
        return clone
    }

    override fun minus(value: Number): Vector4<N> {
        val clone = this.clone
        clone -= value
        return clone
    }

    override fun times(value: Number): Vector4<N> {
        val clone = this.clone
        clone *= value
        return clone
    }

    override fun div(value: Number): Vector4<N> {
        val clone = this.clone
        clone /= value
        return clone
    }
}