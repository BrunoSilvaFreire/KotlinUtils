package me.ddevil.util.math.vector

import me.ddevil.util.immutableMap
import me.ddevil.util.set

abstract class Vector3<N : Number> : Vector2<N>() {
    abstract val z: N


    fun distance(other: Vector3<*>) = (other - this).magnitude

    override val normalized: Vector3<N>
        get() = clone.normalize()

    //Force Vector3<N> return value
    override fun normalize(): Vector3<N> {
        super.normalize()
        return this
    }

    override abstract val clone: Vector3<N>

    override fun serialize(): Map<String, Any> = immutableMap {
        putAll(super.serialize())
        this[Z_IDENTIFIER] = z
    }

    operator fun plusAssign(other: Vector3<*>) {
        super.plusAssign(other)
        plusAssignZ(other.z)
    }


    operator fun minusAssign(other: Vector3<*>) {
        super.minusAssign(other)
        minusAssignZ(other.z)
    }


    operator fun timesAssign(other: Vector3<*>) {
        super.timesAssign(other)
        timesAssignZ(other.z)
    }


    operator fun divAssign(other: Vector3<*>) {
        super.divAssign(other)
        divAssignZ(other.z)
    }

    override operator fun plusAssign(value: Number) {
        super.plus(value)
        plusAssignZ(value)
    }


    override operator fun minusAssign(value: Number) {
        super.minusAssign(value)
        minusAssignZ(value)
    }


    override operator fun timesAssign(value: Number) {
        super.timesAssign(value)
        timesAssignZ(value)
    }


    override operator fun divAssign(value: Number) {
        super.divAssign(value)
        divAssignZ(value)
    }

    operator fun plus(other: Vector3<*>): Vector3<N> {
        val clone = this.clone
        clone += other
        return clone
    }

    operator fun minus(other: Vector3<*>): Vector3<N> {
        val clone = this.clone
        clone -= other
        return clone
    }

    operator fun times(other: Vector3<*>): Vector3<N> {
        val clone = this.clone
        clone *= other
        return clone
    }

    operator fun div(other: Vector3<*>): Vector3<N> {
        val clone = this.clone
        clone /= other
        return clone
    }

    override operator fun plus(value: Number): Vector3<N> {
        val clone = this.clone
        clone += value
        return clone
    }

    override operator fun minus(value: Number): Vector3<N> {
        val clone = this.clone
        clone -= value
        return clone
    }

    override operator fun times(value: Number): Vector3<N> {
        val clone = this.clone
        clone *= value
        return clone
    }

    override operator fun div(value: Number): Vector3<N> {
        val clone = this.clone
        clone /= value
        return clone
    }

    protected abstract fun plusAssignZ(value: Number)

    protected abstract fun minusAssignZ(value: Number)

    protected abstract fun timesAssignZ(value: Number)

    protected abstract fun divAssignZ(value: Number)

    override fun toInt(): Vector3<Int> = IntVector3(x.toInt(), z.toInt(), y.toInt())

    override fun toFloat(): Vector3<Float> = FloatVector3(x.toFloat(), y.toFloat(), z.toFloat())

    override fun toLong(): Vector3<Long> = LongVector3(x.toLong(), y.toLong(), z.toLong())

    override fun toDouble(): Vector3<Double> = DoubleVector3(x.toDouble(), y.toDouble(), z.toDouble())


}