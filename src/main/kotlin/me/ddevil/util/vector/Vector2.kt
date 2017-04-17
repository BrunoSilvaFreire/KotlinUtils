package me.ddevil.util.vector

import me.ddevil.util.Serializable

/**
 * Represents a 2 dimensional vector, with the x and y axis.
 *
 * For a tri-dimensional vector, check [Vector3]
 */
interface Vector2<N : Number> : Comparable<Vector2<*>>, Serializable {
    /**
     * The value of the x axis
     */
    var x: N
    /**
     * The value of the y axis
     */
    var y: N

    /**
     * The magnitude / length / modulus of this vector
     */
    var magnitude: Double

    /**
     * Returns a normalized / "with a [magnitude] of 1" [clone] of this vector.
     *
     * Important note: This does not changes any value in this vector, all of the changes are made in a [clone].
     * If you wish to make changes in this instance of the vector, check [normalize].
     *
     * @see normalize
     */
    val normalized: Vector2<N>

    /**
     * Makes a copy of this vector with the same [x] and [y] values
     */
    val clone: Vector2<N>

    /**
     * The distance from this vector to the [other]
     */
    fun distance(other: Vector2<*>): Double


    /**
     * Changes the [magnitude] of this vector to 1 and returns this instance.
     *
     * Important note: This does changes the [x] and [y] value in this vector.
     * If you don't wish to make changes in this instance of the vector, check [normalized].
     *
     * @see normalize
     */
    fun normalize(): Vector2<N>

    fun toInt(): Vector2<Int>

    fun toFloat(): Vector2<Float>

    fun toLong(): Vector2<Long>

    fun toDouble(): Vector2<Double>

    operator fun plusAssign(other: Vector2<*>)

    operator fun plus(other: Vector2<*>): Vector2<N>

    operator fun minusAssign(other: Vector2<*>)

    operator fun minus(other: Vector2<*>): Vector2<N>

    operator fun timesAssign(other: Vector2<*>)

    operator fun times(other: Vector2<*>): Vector2<N>

    operator fun divAssign(other: Vector2<*>)

    operator fun div(other: Vector2<*>): Vector2<N>


    operator fun plusAssign(value: Number)

    operator fun plus(value: Number): Vector2<N>

    operator fun minusAssign(value: Number)

    operator fun minus(value: Number): Vector2<N>

    operator fun timesAssign(value: Number)

    operator fun times(value: Number): Vector2<N>

    operator fun divAssign(value: Number)

    operator fun div(value: Number): Vector2<N>
}
