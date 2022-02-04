package com.lostbearlabs.aoc.y2020.d3

import com.lostbearlabs.aoc.util.Grid

data class Rule( val right: Int, val down: Int)
data class Pos(val x: Int, val y: Int)

private fun move(p: Pos, r: Rule) : Pos {
    return Pos(p.x+r.right, p.y+r.down)
}

fun countTreesHit(grid: Grid, pos: Pos, rule: Rule): Long {
    if( pos.x >= grid.cols && pos.y >= grid.rows) {
        return 0L
    }

    val hit = if(grid.get(pos.x, pos.y)) 1L else 0L
    val nextPos = move(pos, rule)
    return hit + countTreesHit(grid, nextPos, rule)
}

fun doPart2(grid: Grid) : Long {
    val rules = arrayOf(
            Rule(1,1),
            Rule(3,1),
            Rule(5,1),
            Rule(7,1),
            Rule(1,2)
    )

    val counts = rules.map{ countTreesHit(grid, Pos(0,0), it) }
    return counts.fold(1L, Long::times)
}
