package com.lostbearlabs.aoc.util

fun readList(st: String) : List<Long> {
    return st.split("\n").map { it.toLong() }
}

