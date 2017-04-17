package me.ddevil.util

class Matrix<N> : Iterable<N?> {
    override fun iterator(): Iterator<N?> {
        return arrays.asList().flatMap { it.asList() as List<N?> }.iterator()

    }

    private val arrays: Array<Array<Any?>>

    constructor(width: Int, height: Int) {
        if (width <= 0 || height <= 0) {
            throw IllegalArgumentException("Neither width or height can be less or equal to 0!")
        }
        arrays = Array(width) {
            arrayOfNulls<Any>(height)
        }
    }

    constructor(width: Int, height: Int, populator: (Int, Int) -> N?) {
        if (width <= 0 || height <= 0) {
            throw IllegalArgumentException("Neither width or height can be less or equal to 0!")
        }
        arrays = Array(width) {
            x ->
            Array<Any?>(height) {
                y ->
                populator(x, y)
            }
        }
    }

    val width get() = arrays.size

    val heigth get() = arrays.first().size

    operator fun get(x: Int, y: Int) = arrays[x][y] as N?

    fun getUnsafe(x: Int, y: Int): N {
        val obj = arrays[x][y] ?: throw IllegalArgumentException("There is no object @ $x, $y!")
        return obj as N
    }

    operator fun set(x: Int, y: Int, value: N?) {
        arrays[x][y] = value
    }


}