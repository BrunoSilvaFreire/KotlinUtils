package me.ddevil.util

import java.util.logging.Logger

val Any.globalLogger get() = Logger.getGlobal()
val Any.logger get() = Logger.getLogger(this::class.java.name)