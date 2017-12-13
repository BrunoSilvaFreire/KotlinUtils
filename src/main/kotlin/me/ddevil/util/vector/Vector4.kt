package me.ddevil.util.vector

interface Vector4<N : Number> : Vector3<N> {
    /**
     * The value of the w axis
     */
    var w: N
    /**
     * Returns a normalized / "with a [magnitude] of 1" [clone] of this vector.
     *
     * Important note: This does not changes any value in this vector, all of the changes are made in a [clone].
     * If you wish to make changes in this instance of the vector, check [normalize].
     *
     * @see normalize
     */
    override val normalized: Vector4<N>

    /**
     * Makes a copy of this vector with the same [x] and [y] values
     */
    override val clone: Vector4<N>


    /**
     * The distance from this vector to the [other]
     */
    fun distance(other: Vector4<*>): Double

    /**
     * Changes the [magnitude] of this vector to 1 and returns this instance.
     *
     * Important note: This does changes the [x] and [y] value in this vector.
     * If you don't wish to make changes in this instance of the vector, check [normalized].
     *
     * @see normalize
     */
    override fun normalize(): Vector4<N>

    override fun toInt(): Vector4<Int>

    override fun toFloat(): Vector4<Float>

    override fun toLong(): Vector4<Long>

    override fun toDouble(): Vector4<Double>

    operator fun plusAssign(other: Vector4<*>)

    operator fun plus(other: Vector4<*>): Vector4<N>

    operator fun minusAssign(other: Vector4<*>)

    operator fun minus(other: Vector4<*>): Vector4<N>

    operator fun timesAssign(other: Vector4<*>)

    operator fun times(other: Vector4<*>): Vector4<N>

    operator fun divAssign(other: Vector4<*>)

    operator fun div(other: Vector4<*>): Vector4<N>


    override operator fun plus(value: Number): Vector4<N>

    override operator fun minus(value: Number): Vector4<N>

    override operator fun times(value: Number): Vector4<N>

    override operator fun div(value: Number): Vector4<N>

}