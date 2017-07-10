package me.ddevil.util

import com.google.common.collect.Multiset


operator fun <V> Multiset<V>.plusAssign(value: V) {
    add(value)
}

operator fun <V> Multiset<V>.minusAssign(value: V) {
    remove(value)
}