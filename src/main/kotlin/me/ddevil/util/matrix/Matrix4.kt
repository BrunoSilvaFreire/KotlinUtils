package me.ddevil.util.matrix

data class Matrix4
@JvmOverloads
constructor(
        var xa: Float = 0F,
        var xb: Float = 0F,
        var xc: Float = 0F,
        var xd: Float = 0F,
        var ya: Float = 0F,
        var yb: Float = 0F,
        var yc: Float = 0F,
        var yd: Float = 0F,
        var za: Float = 0F,
        var zb: Float = 0F,
        var zc: Float = 0F,
        var zd: Float = 0F,
        var wa: Float = 0F,
        var wb: Float = 0F,
        var wc: Float = 0F,
        var wd: Float = 0F
) {
    companion object {

        val zero = Matrix4()

        val identity = Matrix4(
                xa = 1F,
                yb = 1F,
                zc = 1F,
                wd = 1F
        )
    }

    fun determinant(): Float {
        return (wa * zb * yc * xa) - (za * wb * yc * xa) - (wa * yb * zc * xd) + (xa * zb * yc * xd) +
                (za * yb * wc * xd) - (ya * zb * wc * xd) - (wa * zb * xc * yd) + (za * wb * xc * yd) +
                (wa * xb * zc * yd) - (xa * wb * zc * yd) - (za * xb * wc * yd) + (xa * zb * wc * yd) +
                (wa * yb * xc * zd) - (ya * wb * xc * zd) - (wa * xb * yc * zd) + (xa * wb * yc * zd) +
                (ya * xb * wc * zd) - (xa * yb * wc * zd) - (za * yb * xc * wd) + (ya * zb * xc * wd) +
                (za * xb * yc * wd) - (xa * zb * yc * wd) - (ya * xb * zc * wd) + (xa * yb * za * wd)
    }
}