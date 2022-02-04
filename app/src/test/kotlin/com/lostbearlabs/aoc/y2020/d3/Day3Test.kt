package com.lostbearlabs.aoc.y2020.d3

import com.lostbearlabs.aoc.util.Grid
import com.lostbearlabs.aoc.util.WrapStyle
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day3Test {

    @Test
    fun samplePart1() {
        val grid = Grid(sample, WrapStyle.Empty, WrapStyle.Repeat)
        val rule = Rule(3,1)
        val treesHit = countTreesHit(grid, Pos(0,0), rule)
        assertThat(treesHit).isEqualTo(7L)
    }

    @Test
    fun part1() {
        val grid = Grid(input, WrapStyle.Empty, WrapStyle.Repeat)
        val rule = Rule(3,1)
        val treesHit = countTreesHit(grid, Pos(0,0), rule)
        assertThat(treesHit).isEqualTo(153L)
    }

    @Test
    fun samplePart2() {
        val grid = Grid(sample, WrapStyle.Empty, WrapStyle.Repeat)
        val product = doPart2(grid)
        assertThat(product).isEqualTo(336L)
    }

    @Test
    fun part2() {
        val grid = Grid(input, WrapStyle.Empty, WrapStyle.Repeat)
        val product = doPart2(grid)
        assertThat(product).isEqualTo(2421944712L)
    }
}

val sample = """
    ..##.......
    #...#...#..
    .#....#..#.
    ..#.#...#.#
    .#...##..#.
    ..#.##.....
    .#.#.#....#
    .#........#
    #.##...#...
    #...##....#
    .#..#...#.#
""".trimIndent()

val input = """
    ........#....#..##..#...#.....#
    ...............#....##........#
    .#....##...##..#...............
    .#.......#......#.##..##...#...
    .....#.#....#..##...#.....#....
    ...#.#..##...###......#..#..#.#
    .....#..##........#.##......#..
    ..##.....###.........##........
    ..............##..#.#.#.#......
    .#....##..#.##.#....#..#.#..#..
    .#.#....#.##.#...#....#.....#..
    ..#...#.#.....#....#.......##..
    .#.#..##.....#...........#.....
    .#.##...#.....#......#.##......
    ..#..#..........#.....#..###.#.
    ##....##....#.#...........#..#.
    .....#.#.......#.#.#..#.##....#
    ...##.#....#..#.....#.........#
    .....#........#.##...#.........
    .....#................#.#...#..
    ...#....##.....##....#.......#.
    ....##.#.....#.#.......#.......
    #...............#..#...........
    .......###.#.......#.##....#.#.
    ..#........###........#......#.
    .#.......#...##.....####....##.
    ..##.#....#.....#..#....#......
    ..#...#..#.#..##...#.....#.....
    .#.......###.......#....#......
    ...#...#.......#........#...#.#
    ..#....#...#.......#.#..##.....
    ##............#.#..#..........#
    .......###...##..#.....#....#..
    ##..######.#..#.......###....##
    ###..#...#.##......##....#...#.
    ..............##.###..........#
    .....#........##.#.###....#....
    ..#...#.....##.#......#.#..#.#.
    #....#.............#.#.........
    .........##.#........#...#.....
    ..........#..##.#.#.....#..##..
    ........##......#..#..#...#.#..
    .##.......#..#.#...#.####..#...
    ##...#........#.###...##....#..
    ....###.####...#..#..#......###
    #....#....#.#.....##.........#.
    #.......#....#....##...........
    ##...##.#.......#....#...#....#
    ....#....#........##..#.#..#.#.
    ..##.....##...#..........#...#.
    .#.#.#...#.....##..#........#..
    #....#.....#..........#....#...
    ...##.#.......#.#.........#....
    ##.##.........##.....##.....##.
    ##.#..##..#...##........##.....
    .........##.......#....#...#...
    .#.....#........####.#.#.....#.
    ...........##..#.###...........
    ..#....##....#...#.............
    #.#............#.......#.......
    .##........#...#..##.....#.#...
    #.##..............##..##.......
    ##.........#......#......#..#..
    ##.#....#...#....##....#..#.##.
    ......#...#..#.#...#.#....#.##.
    ##.......#.....#.........#.....
    ...##...#................#.#...
    ....#.####...#.#.....##....##.#
    #...#..#.#.##................##
    .........##.....##...#..#......
    ......####....#.##.#.....#.....
    ...#..#.#....#.#.#..#..........
    .....#........##...#.##....#.#.
    ..##......#...................#
    .....#..#...............#..#...
    ....#........#..#.#...##...#.##
    ..#.#.......#.##.........#...#.
    ...##......#.#.................
    .#....#...#.............##.#...
    ........#.##...#..#...###.....#
    #....#.#........##....#......##
    .###.......#..#..........#..#..
    #....#..#....#........#...#...#
    ##.#.###.##.#...##.#......#.#.#
    #..#..#..##........#..###.#...#
    ....#..#..#.....#...##....#...#
    .......##.......#..#.##...##..#
    .##....#..###................##
    #...#.##.##...#.##......##.....
    ...##.....##..##...#..#........
    ...............##.....##.......
    .#..#.#..#....#.....#..#...#...
    .#....#..#........#.#...#.....#
    ##.....####..#......#..........
    ........#.........#.........#..
    #...####....#.##...#....#...##.
    .#....####..#...##..#......####
    ...........##.##..#.##...##....
    ..#..#.......#.##....#.#...#.##
    #...........#..#...............
    .......#.##..#.....##......#...
    ....##.#.##.....#...........#.#
    .............#.##..#...#......#
    #......#...........#........#..
    #.#..#.............#...#.......
    #.........##...#....#...##.....
    ##...#..#..#..#....#...........
    .#.....#........#.....#.##..#.#
    ...#..............##.####.#..#.
    ##.....#..#.#..#..##...........
    ...#...#.......#...............
    ..#..................###..#..##
    ....###..........#.#..#...#.#.#
    ..#..#..#.#..........#.#......#
    ....#....#.#...#.###...##..#...
    ....#.......#...#....##........
    .#.....#.......###....#........
    ....#..#..#.....#......#.......
    ......#...#..#....#.#.......#..
    .##.#..#...#.#.#...........#...
    ..#....##.#....#.#....#...#.#.#
    ...##..#.......#....#.#.....##.
    ##.#......#.#.......##...#.....
    ......#...#.##..............#..
    .##.........#......##.#..#....#
    #.......#.....#...##...#..#...#
    ..#..##.......#......#......##.
    #..##...###.#.#...........#....
    ##......#.....####..#..#....#.#
    .......##...##.#...#...........
    ....#..#.##.#.....#.#....#.#...
    ....#.....#.....####...#..#.##.
    .##..#..#..###...#....#.##.#.#.
    ..#.#.##..........##...........
    #.##.#.#....#.##....#..#...##.#
    #...#....#...###....#.......#..
    .......#..#............#.......
    ................##.#.#.....#..#
    ..........................#....
    .##....##...#.#....####..#....#
    ......#...#....#...#.##..###.#.
    .........#............#.......#
    .#.#..#........#..#.........#..
    #..#...#......#.#....#..#.#....
    ...........#.................#.
    .#.#..#...##..###......##....##
    .#.#.##......####.........##...
    ..#....#.#..#................#.
    ##.......#....#.........##.#.#.
    ##..#.###...........#..#.#..#.#
    ...#............##.#....#......
    ...#................##.#..#....
    ....#..##.#...#.#.....#.......#
    ......#......#.#........#..##..
    ...##...#.....#.##.......#.....
    ##...#...#.............#..#....
    ..#...##.....#..........#..#.##
    #.##...#..................#.###
    .........#..........#.###...#.#
    #..#.....#.#.#....#......#...#.
    .............#.##..###.....#.##
    ..#..#.....#..#.............#..
    .#.....##.#.#..#.........#.....
    ..#.......#....#.....##.#......
    .#.........#..#....##...#.##...
    .##..##................###....#
    .#..##..............#...#......
    .#..............#.##....##.....
    .#......#..#..##..#...###.....#
    ................##...#.#..#...#
    ##.#.......#...................
    ....#.#.......#..#.##..........
    ....###............##...#......
    .......#....#.#.....##.#.....#.
    ....#...............#.#........
    ..#.##....#.#.#......##..#.....
    .##......#...#.#..#..#.......#.
    ....#...#........#.#..##.......
    .##...###.#....#..........##..#
    ..#.......##..#.....###......#.
    ...#.#..##.#.#...........#.....
    ##........#.#..##.........#..#.
    .....###.......#..#.#.....##.#.
    ..#...##.#..............#......
    ......#...#...............##.#.
    ##...#..#....#...#.####.##.....
    ...#............#.##...........
    ...#........##.#.##.......#....
    ...#..#..##....#...#......#..#.
    #.....#..#......#.#.....##.#.#.
    .....#.##......#...#..#..###..#
    ...........##..##.#.#..........
    ...#........##........##..##.#.
    ......###...#.....#..###.#..#..
    #.....#.#....#...##....##.....#
    .##....#......#.....#.#..##.##.
    ##....###.......#...##.......##
    ...##......#....###............
    ..#...#...#.#..#..........##.#.
    #.#.###...#..#.....#....#.###..
    ..##.....#.#.#.......#.........
    ...####..#....#..#.........#...
    .##...........#.##.#...#.#.##..
    ...#.#....#.##......#........#.
    ##....##....#..#...#..#.#......
    #......#..#...#...#.#.#.#.####.
    ....##.#.#.....#.###........#..
    ....##..#.#.#.#....#....#.#..#.
    ..#.###..#............##..#.#..
    ...#...#..#...#.#.#.....#.....#
    ..........#.....#..#.......##.#
    ..............##...........#...
    .......#.....#...#.....#.....#.
    .#.###.....##......##....#...#.
    .....#.........#.#....#........
    ..#.#....#.##...#.##....##...#.
    ...#......#.#.....#.......###..
    #.##....##.....#.#.#...#......#
    #..#...#..........#.........##.
    ....#.#.#.#.....#...###........
    #.#..#...#......#...#.##...####
    .#...#......#....##...#........
    ..#.........#............#...#.
    ##......#..#...#....#.##....#..
    .#...##..#..##.#.#.#........#.#
    .##.........###...#......#..###
    ...##.....##..#.#.........#....
    ...........##........#...#.....
    ..##..#...#..#..#.....#......#.
    ..#..#.#....#.....#..#.##...#..
    #....#........##..........#.###
    ......#...#...#....#...##.#....
    ...#......#.#.....##......##...
    #....#..##............#....#.#.
    ...#...##.#..........##........
    ......#.###......#...#.#.......
    ..................#.##..#..#..#
    ....#.....#...#.....#...#....#.
    .#....##.#..#..#.....###.##...#
    #.......#..#....##.##.#.....##.
    ..##........##...#.....#....##.
    #.........#...........##.#.....
    .#....#.#...##..###..........#.
    ....##..##....####...#......#..
    ##.##..#..#....#....####...#...
    ..#...............#.##.........
    ...#.#....#..#....#......#.....
    .#..#...#........#...#.....##..
    #.....###.......#.....#........
    ...#.##..#.......#....#........
    ....##..###.##...#.#....#.#....
    #.####...#.......#.....#.#....#
    #.......#......#.......#.#.#...
    ##....#......#..#...#..#..####.
    .##.....#........#..#...#......
    #.#.#....#....#...#.##..##.....
    ....#..#.........###.##.##.....
    ...##...##.###..#..##.....#.###
    ..###.......................#..
    ......##..#.#.........#......#.
    .###......##....#.....#.......#
    .....#..#..##........#......##.
    ..##.....#....#.#.............#
    ..##.........##.#..#.........##
    ......#......#.#......#........
    .#...#..#......##...#..#....#..
    ...............###............#
    #.####.#....#...#...........#.#
    ............................#.#
    .#..#...#.#.#.###..##.....##...
    ....##...#.................##..
    ......##....#...............##.
    .#......#.##.#..#.....##...##..
    .............#........#......#.
    #..........#.#....#####.#...#.#
    .#.#...##..#.#...#.#..#.#..#...
    #.##.......##......#.#.#....#..
    ##.....##.#.#.##..........##..#
    ....##..#.#.......#....#.##....
    ..#.#.#...#.....#.......#......
    .#....#..#...........###.......
    #.#...#.....#......#...#.....#.
    #........#.#..........#...#.#..
    ...#...#....#.........#........
    .....................#..##.....
    ...#......##........#.##.#.#.##
    .............###...#.#...#..#..
    .#..##........##....#...###..##
    .#..#.#...............#.....##.
    ...........##.#....#..##.#....#
    .##.#.#..#.#..#...#.#.#..#.#.##
    .......#.#..#..#..#..#...#.....
    .#......##............#.#..#...
    ..#...#..##..#..#...##......#..
    ...##......##....#............#
    .......#.....##...##.#...#..#..
    ......#.......#..##.........#..
    ..#...#.#.....#.#.......#.#...#
    .#......##.##.#.#.#.##..#....##
    #.....#.........#.#....#....##.
    .......#.........#....#..#.#.##
    .....##....#..#.#.#...#.....##.
    #####.#.......######......#....
    ..##.#.......#.#..............#
    ..#.##....#.....#...#.#...##...
    .....#...#..#....#.#..#........
    .#....#.#..#.#.#.##..#.......#.
    ....#..#..#..........##...#....
    .......#.#......#........#.....
    ##.#.#.###....##.#..#..#....#..
    #.##......#..#.......#.#...#...
    ..##...#.......#.......#...#...
    ........##.........#.#....#.#..
    ..#...#..##.#.#.#...#....#.....
    .###......#........#....#...#..
    .#.......##......###..##.......
    #....#.#....#.##.........####..
    ......#..........#..##.....#...
    .............#......#..##.#....
    ...................#....#...#..
    .#..........#...#.#..##...#....
    .....#...#..........##.##......
    #...#..#.##........#...#.......
""".trimIndent()