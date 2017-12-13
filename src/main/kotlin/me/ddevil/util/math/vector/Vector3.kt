package me.ddevil.util.math.vector

import java.util.*

/**
 * Represents a 3 dimensional vector, with the x and y axis.
 *
 * For a bi-dimensional vector, check [Vector2]
 */
interface Vector3<N : Number> : Vector2<N> {
    /**
     * The value of the z axis
     */
    var z: N

    /**
     * Returns a normalized / "with a [magnitude] of 1" [clone] of this vector.
     *
     * Important note: This does not changes any value in this vector, all of the changes are made in a [clone].
     * If you wish to make changes in this instance of the vector, check [normalize].
     *
     * @see normalize
     */
    override val normalized: Vector3<N>

    /**
     * Makes a copy of this vector with the same [x] and [y] values
     */
    override val clone: Vector3<N>

    /**
     * The distance from this vector to the [other]
     */
    fun distance(other: Vector3<*>): Double


    /**
     * Changes the [magnitude] of this vector to 1 and returns this instance.
     *
     * Important note: This does changes the [x] and [y] value in this vector.
     * If you don't wish to make changes in this instance of the vector, check [normalized].
     *
     * @see normalize
     */
    override fun normalize(): Vector3<N>

    override fun toInt(): Vector3<Int>

    override fun toFloat(): Vector3<Float>

    override fun toLong(): Vector3<Long>

    override fun toDouble(): Vector3<Double>

    operator fun plusAssign(other: Vector3<*>)

    operator fun plus(other: Vector3<*>): Vector3<N>

    operator fun minusAssign(other: Vector3<*>)

    operator fun minus(other: Vector3<*>): Vector3<N>

    operator fun timesAssign(other: Vector3<*>)

    operator fun times(other: Vector3<*>): Vector3<N>

    operator fun divAssign(other: Vector3<*>)

    operator fun div(other: Vector3<*>): Vector3<N>


    override operator fun plus(value: Number): Vector3<N>

    override operator fun minus(value: Number): Vector3<N>

    override operator fun times(value: Number): Vector3<N>

    override operator fun div(value: Number): Vector3<N>
}