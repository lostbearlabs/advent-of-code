package com.lostbearlabs.aoc.y2020.d1

fun findPairProduct(tgt: Long, lst: List<Long>) : Long? {
    val values = lst.toSet()
    val x = lst.find { values.contains(tgt-it) } ?: return null
    val y = tgt-x
    return y*x
}

fun findTripleProduct(tgt: Long, lst: List<Long>) : Long? {
    val x = lst.find { findPairProduct(tgt-it, lst) != null } ?: return null
    return x * findPairProduct(tgt-x, lst)!!
}
