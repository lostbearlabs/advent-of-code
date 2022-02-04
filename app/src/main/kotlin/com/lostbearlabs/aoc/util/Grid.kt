package com.lostbearlabs.aoc.util

enum class WrapStyle {
    Repeat,
    Empty,
    Throw
}

class Grid(text: String, val rowWrap: WrapStyle, val colWrap: WrapStyle) {
    private val grid : Array<Boolean>
    val rows : Int
    val cols : Int

    init {
        grid = text
                .trim()
                .replace("\n", "")
                .map{ it == '#'}
                .toTypedArray()
        rows = 1 + text.count { it == '\n' }
        cols = grid.size / rows
    }

    private fun idx(row: Int, col: Int) : Int {
        return row*cols + col
    }

    fun get(x: Int, y: Int) : Boolean {
        val ii = (y+rows) % rows
        val jj = (x+cols) % cols

        if( ii!=y ) {
            when(rowWrap) {
                WrapStyle.Empty -> return false
                WrapStyle.Throw -> throw IndexOutOfBoundsException("bad row index")
            }
        }

        if( jj!=x ) {
            when(colWrap) {
                WrapStyle.Empty -> return false
                WrapStyle.Throw -> throw IndexOutOfBoundsException("bad col index")
            }
        }

        return grid[ idx(ii, jj) ]
    }

}