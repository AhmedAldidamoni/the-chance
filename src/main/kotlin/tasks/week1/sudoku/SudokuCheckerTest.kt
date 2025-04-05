package tasks.week1.sudoku

import util.printTestResult

private fun main() {
    println("Valid cases:")
    testValidCases()

    println("\nInvalid cases:")
    testInvalidCases()
}

private fun testValidCases() {
    checkValidSudoku(
        listOf(
            listOf('1', '2', '3', '4'),
            listOf('3', '4', '1', '2'),
            listOf('2', '3', '4', '1'),
            listOf('4', '1', '2', '3')
        )
    ).printTestResult(true, "Valid 4x4 grid: Allowed characters are '1'-'4'")

    checkValidSudoku(
        listOf(
            listOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
            listOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
            listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
            listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
            listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
            listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
            listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
            listOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
            listOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
        )
    ).printTestResult(true, "Valid 9x9 grid: Allowed characters are '1'-'9'")

    checkValidSudoku(
        listOf(
            listOf('1','2','-','4','5','-','7','8','9','A','B','C','D','E','F','G'),
            listOf('5','6','7','8','9','A','B','C','D','E','F','G','1','2','3','4'),
            listOf('9','A','B','-','D','E','F','G','1','2','3','4','5','6','7','8'),
            listOf('D','E','F','G','1','2','3','4','5','6','7','8','9','A','B','C'),
            listOf('2','3','4','5','6','7','8','9','A','-','C','D','E','F','G','1'),
            listOf('6','7','8','9','A','B','C','D','E','F','G','1','2','3','4','5'),
            listOf('A','B','C','D','E','-','G','1','2','3','4','5','6','7','8','9'),
            listOf('E','F','G','1','2','3','4','5','6','7','8','9','A','B','C','D'),
            listOf('3','4','5','6','7','8','9','A','B','C','D','E','F','G','1','2'),
            listOf('7','8','9','A','B','C','D','E','F','G','-','2','3','4','5','6'),
            listOf('B','C','D','E','F','G','1','2','3','4','5','6','7','8','9','A'),
            listOf('F','G','1','2','-','4','5','6','7','8','9','A','-','C','D','E'),
            listOf('4','5','6','7','8','9','A','B','C','D','E','F','G','1','2','3'),
            listOf('8','9','A','B','C','D','E','F','-','1','2','3','4','5','6','7'),
            listOf('C','D','-','F','G','1','2','3','4','5','6','7','8','9','A','B'),
            listOf('G','1','2','3','4','-','6','7','8','9','A','B','C','D','E','F')
        )
    ).printTestResult(true, "Valid 16x16 grid: Allowed characters are '1'-'9' and 'A'-'G'")
}

private fun testInvalidCases() {
    checkValidSudoku(
        listOf(
            listOf('1', '2', '3', '4'),
            listOf('1', '2', '3'), // shorter row
            listOf('1', '2', '3', '4'),
            listOf('1', '2', '3', '4')
        )
    ).printTestResult(false, "Invalid grid: not all rows have the same size")

    checkValidSudoku(
        List(6) { List(6) { '-' } }
    ).printTestResult(false, "Invalid grid: unsupported size 6x6")

    checkValidSudoku(
        listOf(
            listOf('1', '2', '3', '5'), // '5' is invalid
            listOf('3', '4', '1', '2'),
            listOf('2', '3', '4', '1'),
            listOf('4', '1', '2', '3')
        )
    ).printTestResult(false, "Invalid 4x4 grid: character out of allowed characters (1-4)")

    checkValidSudoku(
        List(9) { row ->
            List(9) { col ->
                if (row == 0 && col == 0) 'A' else '1' // 'A' is invalid
            }
        }
    ).printTestResult(false, "Invalid 9x9 grid: character out of allowed characters (1-9)")

    checkValidSudoku(
        List(16) { row ->
            List(16) { col ->
                if (row == 5 && col == 5) 'Z' else '1' // 'Z' is invalid
            }
        }
    ).printTestResult(false, "Invalid 16x16 grid: character out of allowed characters (1–9, A–G)")

    checkValidSudoku(
        listOf(
            listOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
            listOf('6', '5', '-', '1', '9', '5', '-', '-', '-'), // duplication in row
            listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
            listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
            listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
            listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
            listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
            listOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
            listOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
        )
    ).printTestResult(false, "Invalid grid: duplication in row")

    checkValidSudoku(
        listOf(
            listOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
            listOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
            listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
            listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
            listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
            listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
            listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
            listOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
            listOf('5', '-', '-', '-', '8', '-', '-', '7', '9') // duplication in column
        )
    ).printTestResult(false, "Invalid grid: duplication in column")

    checkValidSudoku(
        listOf(
            listOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
            listOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
            listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
            listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
            listOf('4', '-', '8', '8', '-', '3', '-', '-', '1'), // duplication in sub-grid
            listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
            listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
            listOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
            listOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
        )
    ).printTestResult(false, "Invalid grid: duplication in sub-grid")
}
