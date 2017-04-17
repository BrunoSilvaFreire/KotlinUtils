package me.ddevil.util

fun Number.toSecondsString(): String {
    val pTime = this.toInt()
    return String.format("%02d:%02d", pTime / 60, pTime % 60)
}

fun String.capitalize(): String {
    val length: Int = length
    if (length != 0) {
        val firstChar = this[0]
        return if (Character.isTitleCase(firstChar)) this else StringBuilder(length).append(Character.toTitleCase(firstChar)).append(this.substring(1)).toString()
    } else {
        return this
    }
}