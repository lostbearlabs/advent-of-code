package util

import com.lostbearlabs.aoc.util.Grid
import com.lostbearlabs.aoc.util.WrapStyle
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class GridTest {
    @Test
    fun `parse sample - reads size correctly`() {
        val grid = Grid(sample, WrapStyle.Empty, WrapStyle.Repeat)
        assertThat(grid.rows).isEqualTo(6)
        assertThat(grid.cols).isEqualTo(11)
    }

    @Test
    fun `parse sample - reads values correctly`() {
        val grid = Grid(sample, WrapStyle.Empty, WrapStyle.Repeat)
        assertThat(grid.get(0,0)).isFalse
        assertThat(grid.get(0,1)).isFalse
        assertThat(grid.get(0,2)).isTrue
        assertThat(grid.get(0,3)).isTrue
        assertThat(grid.get(0,4)).isFalse
        
        assertThat(grid.get(1,0)).isFalse
        assertThat(grid.get(1,1)).isTrue
        assertThat(grid.get(1,2)).isFalse
        assertThat(grid.get(1,3)).isTrue
        assertThat(grid.get(1,4)).isFalse
        
        // etc
    }


    @Test
    fun `parse sample - row wrap Empty - gets values correctly`() {
        val text = "###\n###\n###"
        val grid = Grid(text, WrapStyle.Empty, WrapStyle.Throw)
        assertThat(grid.get(3, 0)).isFalse
    }

    @Test
    fun `parse sample - row wrap Repeat - gets values correctly`() {
        val text = "###\n###\n###"
        val grid = Grid(text, WrapStyle.Repeat, WrapStyle.Throw)
        assertThat(grid.get(3, 0)).isTrue
    }

    @Test
    fun `parse sample - col wrap Empty - gets values correctly`() {
        val text = "###\n###\n###"
        val grid = Grid(text, WrapStyle.Throw, WrapStyle.Empty)
        assertThat(grid.get(0, 3)).isFalse
    }

    @Test
    fun `parse sample - col wrap Repeat - gets values correctly`() {
        val text = "###\n###\n###"
        val grid = Grid(text, WrapStyle.Throw, WrapStyle.Repeat)
        assertThat(grid.get(0, 3)).isTrue
    }
}


val sample = """
    ..##.......
    .#.#.#....#
    .#........#
    #.##...#...
    #...##....#
    .#..#...#.#
""".trimIndent()
