package me.ddevil.util

val Enum<*>.byteOrdinal get() = this.ordinal.toByte()

val Enum<*>.shortOrdinal get() = this.ordinal.toShort()

val Enum<*>.longOrdinal get() = this.ordinal.toLong()