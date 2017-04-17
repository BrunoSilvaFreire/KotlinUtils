package me.ddevil.util.vector

import com.google.common.collect.ImmutableMap

abstract class AbstractVector3<N : Number> : AbstractVector2<N>(), Vector3<N> {
    override fun serialize(): Map<String, Any> = ImmutableMap.builder<String, Any>()
            .putAll(super.serialize())
            .put(Z_IDENTIFIER, z)
            .build()

    protected abstract fun plusAssignZ(value: Number)


    protected abstract fun minusAssignZ(value: Number)


    protected abstract fun timesAssignZ(value: Number)

    protected abstract fun divAssignZ(value: Number)
    override fun distance(other: Vector3<*>) = (other - this).magnitude
    override val normalized: Vector3<N>
        get() = clone.normalize()

    override fun normalize(): Vector3<N> {
        super.normalize()
        return this
    }

    override fun toInt(): Vector3<Int> = IntVector3(x.toInt(), z.toInt(), y.toInt())

    override fun toFloat(): Vector3<Float> = FloatVector3(x.toFloat(), y.toFloat(), z.toFloat())

    override fun toLong(): Vector3<Long> = LongVector3(x.toLong(), y.toLong(), z.toLong())

    override fun toDouble(): Vector3<Double> = DoubleVector3(x.toDouble(), y.toDouble(), z.toDouble())


    override fun plusAssign(other: Vector3<*>) {
        super.plusAssign(other)
        plusAssignZ(other.z)
    }


    override fun minusAssign(other: Vector3<*>) {
        super.minusAssign(other)
        minusAssignZ(other.z)
    }


    override fun timesAssign(other: Vector3<*>) {
        super.timesAssign(other)
        timesAssignZ(other.z)
    }


    override fun divAssign(other: Vector3<*>) {
        super.divAssign(other)
        divAssignZ(other.z)
    }

    override fun plusAssign(value: Number) {
        super.plus(value)
        plusAssignZ(value)
    }


    override fun minusAssign(value: Number) {
        super.minusAssign(value)
        minusAssignZ(value)
    }


    override fun timesAssign(value: Number) {
        super.timesAssign(value)
        timesAssignZ(value)
    }


    override fun divAssign(value: Number) {
        super.divAssign(value)
        divAssignZ(value)
    }

    override fun plus(other: Vector3<*>): Vector3<N> {
        val clone = this.clone
        clone += other
        return clone
    }

    override fun minus(other: Vector3<*>): Vector3<N> {
        val clone = this.clone
        clone -= other
        return clone
    }

    override fun times(other: Vector3<*>): Vector3<N> {
        val clone = this.clone
        clone *= other
        return clone
    }

    override fun div(other: Vector3<*>): Vector3<N> {
        val clone = this.clone
        clone /= other
        return clone
    }

    override fun plus(value: Number): Vector3<N> {
        val clone = this.clone
        clone += value
        return clone
    }

    override fun minus(value: Number): Vector3<N> {
        val clone = this.clone
        clone -= value
        return clone
    }

    override fun times(value: Number): Vector3<N> {
        val clone = this.clone
        clone *= value
        return clone
    }

    override fun div(value: Number): Vector3<N> {
        val clone = this.clone
        clone /= value
        return clone
    }


}