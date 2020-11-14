/**
 * https://leetcode.com/problems/n-queens/
 *
 * Time Complexity:     O(`n` ^ (`n` + 1))
 * Space Complexity:    O()
 *
 * References:
 *  https://mp.weixin.qq.com/s/nMUHqvwzG2LmWA9jMIHwQQ
 */
package com.zea7ot.leetcode.lvl4.lc0051

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    private companion object {
        private const val QUEEN = 'Q'
        private const val EMPTY = '.'
    }

    fun solveNQueens(n: Int): List<List<String>> {
        val board = MutableList(n) { CharArray(n) { EMPTY } }

        val ans = mutableListOf<List<String>>()
        backtrack(0, board, ans)
        return ans
    }

    private fun backtrack(row: Int,
                          board: MutableList<CharArray>,
                          res: MutableList<List<String>>) {

        val nRows = board.size
        if (row == nRows) {
            res.add(construct(board))
            return
        }

        for (col in board[row].indices) {
            if (!isValid(row, col, board)) continue

            board[row][col] = QUEEN
            backtrack(row + 1, board, res)
            board[row][col] = EMPTY
        }
    }

    private fun isValid(row: Int,
                        col: Int,
                        board: MutableList<CharArray>): Boolean {

        for (i in board.indices) {
            for (j in board[i].indices) {
                if (board[i][j] == QUEEN
                        && (row + j == col + i || row + col == i + j || col == j))
                    return false
            }
        }

        return true
    }

    private fun construct(board: MutableList<CharArray>): List<String> {
        val ans = mutableListOf<String>()
        for (chs in board) {
            ans.add(String(chs))
        }
        return ans
    }
}