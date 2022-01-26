package com.lostbearlabs.aoc.y2020.d2

data class Entry(val c: Char, val nMin: Int, val nMax: Int, val pwd: String)

// 1-3 a: abcde
val regex = """(\d+)-(\d+) (.): (.+)""".toRegex()

fun parsePasswordEntry(st: String): Entry {
    val x = regex.matchEntire(st)!!
    val vals = x.groupValues
    return Entry(vals[3][0], vals[1].toInt(), vals[2].toInt(), vals[4])
}

fun parsePasswordEntries(st: String): List<Entry> {
    return st.split("\n")
            .map { parsePasswordEntry(it) }
}

fun validPart1(e: Entry): Boolean {
    val n = e.pwd.count { it == e.c }
    return n >= e.nMin && n <= e.nMax
}

fun validPart2(e: Entry): Boolean {
    val b1 = e.pwd[e.nMin - 1] == e.c
    val b2 = e.pwd[e.nMax - 1] == e.c
    return b1 xor b2
}


fun numValidPasswords(ar: List<Entry>, fnValid: (e: Entry) -> Boolean): Int {
    return ar.count { fnValid(it) }
}

