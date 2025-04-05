package tasks.week1.sudoku

import util.isSquareGrid
import kotlin.math.sqrt

fun checkValidSudoku(grid: List<List<Char>>): Boolean {
    // valid square grid (all rows have the same size && rows == columns)
    if (!grid.isSquareGrid()) return false

    // valid grid size must be either 4x4, 9x9, or 16x16 only
    val sudokuGrid = SudokuGrid.entries.find { it.size == grid.size } ?: return false

    // valid characters (for 4x4 -> 1~4, for 9x9 -> 1~9, for 16x16 -> 1~9 A~G)
    grid.forEach { row ->
        row.forEach { char ->
            if (char !in sudokuGrid.characters) return false
        }
    }

    // duplication in columns
    for (row in grid) {
        val seen = mutableSetOf<Char>()
        for (c in row) {
            if (c == '-') continue
            if (!seen.add(c)) return false
        }
    }

    // duplication in rows
    for (col in grid.indices) {
        val seen = mutableSetOf<Char>()
        for (row in grid) {
            val c = row[col]
            if (c == '-') continue
            if (!seen.add(c)) return false
        }
    }

    // duplication in sub-grids
    val blockSize = sqrt(grid.size.toDouble()).toInt()
    for (rowStart in grid.indices step blockSize) {
        for (colStart in grid.indices step blockSize) {
            val seen = mutableSetOf<Char>()
            for (r in rowStart until rowStart + blockSize) {
                for (c in colStart until colStart + blockSize) {
                    val char = grid[r][c]
                    if (char == '-') continue
                    if (!seen.add(char)) return false
                }
            }
        }
    }

    return true
}

// Utilize enum since the valid sudoku grid sizes are only (4x4, 9x9, or 16x16).
// Note: not all perfect square sizes are valid, for example 1x1 is considered invalid, also larger sizes like 25x25
enum class SudokuGrid(val size: Int, val characters: List<Char>) {
    Grid4x4(4, listOf('-', '1', '2', '3', '4')),
    Grid9x9(9, listOf('-', '1', '2', '3', '4', '5', '6', '7', '8', '9')),
    Grid16x16(16, listOf('-', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G'))
}