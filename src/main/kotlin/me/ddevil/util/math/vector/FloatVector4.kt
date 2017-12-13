package me.ddevil.util.math.vector

import me.ddevil.util.getFloat
import kotlin.math.sqrt

open class FloatVector4 : Vector4<Float> {


    final override var x: Float
    final override var y: Float
    final override var z: Float
    final override var w: Float

    constructor(map: Map<String, Any>) {
        x = map.getFloat(X_IDENTIFIER)
        y = map.getFloat(Y_IDENTIFIER)
        z = map.getFloat(Z_IDENTIFIER)
        w = map.getFloat(W_IDENTIFIER)
    }
    
    @JvmOverloads
    constructor(x: Float = 0.0F, y: Float = 0.0F, z: Float = 0.0F, w: Float = 0.0F) : super() {
        this.x = x
        this.y = y
        this.z = z
        this.w = w
    }

    override val clone: Vector4<Float> get() = FloatVector4(x, y, z, w)

    override fun toFloat(): Vector4<Float> = this

    override fun plusAssignX(value: Number) {
        x += value.toFloat()
    }

    override fun plusAssignY(value: Number) {
        y += value.toFloat()
    }

    override fun plusAssignZ(value: Number) {
        z += value.toFloat()
    }

    override fun minusAssignX(value: Number) {
        x -= value.toFloat()
    }

    override fun minusAssignY(value: Number) {
        y -= value.toFloat()
    }

    override fun minusAssignZ(value: Number) {
        z -= value.toFloat()
    }

    override fun timesAssignX(value: Number) {
        x *= value.toFloat()
    }

    override fun timesAssignY(value: Number) {
        y *= value.toFloat()
    }

    override fun timesAssignZ(value: Number) {
        z *= value.toFloat()
    }

    override fun divAssignX(value: Number) {
        x /= value.toFloat()
    }

    override fun divAssignY(value: Number) {
        y /= value.toFloat()
    }

    override fun divAssignZ(value: Number) {
        z /= value.toFloat()
    }

    override fun plusAssignW(value: Number) {
        w += value.toFloat()
    }

    override fun minusAssignW(value: Number) {
        w -= value.toFloat()
    }

    override fun timesAssignW(value: Number) {
        w *= value.toFloat()
    }

    override fun divAssignW(value: Number) {
        w /= value.toFloat()
    }

    override fun toGeneric(value: Number) = value.toFloat()

}