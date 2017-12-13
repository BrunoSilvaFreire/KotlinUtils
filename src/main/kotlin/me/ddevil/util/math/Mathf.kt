package me.ddevil.util.math

const val DEG_2_RAG = 0.0174532924F

const val RAD_2_DEG = 57.29578F
const val PI = Math.PI.toFloat()
fun sinRad(radians: Double): Float {
    return Math.sin(radians).toFloat()
}

fun cosRad(radians: Double): Float {
    return Math.cos(radians).toFloat()
}

fun atan2Rad(x: Double, y: Double): Float {
    return Math.atan2(y, x).toFloat()
}

fun asinRad(radians: Double): Float {
    return Math.asin(radians).toFloat()
}

fun sin(angle: Float): Float {
    return sinRad((angle * DEG_2_RAG).toDouble())
}

fun cos(angle: Float): Float {
    return cosRad((angle * DEG_2_RAG).toDouble())
}

fun atan2(x: Float, y: Float): Float {
    return atan2Rad((x * DEG_2_RAG).toDouble(), (y * DEG_2_RAG).toDouble())
}

fun asin(angle: Float): Float {
    return asinRad((angle * DEG_2_RAG).toDouble())
}

fun fabs(value: Float): Float {
    if (value < 0) {
        return -value
    }
    return value
}

fun copysign(value: Float, sign: Float): Float {
    return Math.copySign(value, sign)
}