/**
 * https://leetcode.com/problems/diagonal-traverse/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.an7one.leetcode.lvl3.lc0498

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.HashMap

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun findDiagonalOrder(matrix: Array<IntArray>): IntArray {
        if (matrix.isEmpty()) return intArrayOf()

        val nRows = matrix.size
        val nCols = matrix[0].size

        val levelToNums = HashMap<Int, LinkedList<Int>>()
        for (row in matrix.indices) {
            for (col in matrix[row].indices) {
                val lvl = row + col
                val level = levelToNums.getOrPut(lvl) { LinkedList() }

                if (lvl % 2 == 0) {
                    level.addFirst(matrix[row][col])
                } else {
                    level.addLast(matrix[row][col])
                }
            }
        }

        val ans = IntArray(nRows * nCols) { 0 }
        var idx = 0
        for ((_, nums) in levelToNums) {
            for (num in nums) {
                ans[idx++] = num
            }
        }

        return ans
    }
}