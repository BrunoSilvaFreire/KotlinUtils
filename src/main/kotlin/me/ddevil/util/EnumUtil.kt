package me.ddevil.util

inline fun <reified E: Enum<E>> randomEnum() = enumValues<E>().random()
inline fun <reified E : Enum<E>> enumValueWithIndex(index: Int): E {
    val values = enumValues<E>()
    if (index > values.lastIndex) {
        throw IllegalArgumentException("Unknown enum ${E::class.java.name} with index $index")
    }
    return values[index]
}

val Enum<*>.byteOrdinal get() = this.ordinal.toByte()

val Enum<*>.shortOrdinal get() = this.ordinal.toShort()

val Enum<*>.longOrdinal get() = this.ordinal.toLong()