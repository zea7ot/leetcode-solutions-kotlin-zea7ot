/**
 * https://leetcode.com/problems/unique-paths/
 *
 * Time Complexity:     O(`m` * `n`)
 * Space Complexity:    O(`n`)
 *
 * References:
 *  https://leetcode.com/problems/unique-paths/discuss/22954/C%2B%2B-DP
 */
package com.an7one.leetcode.lvl1.lc0062

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen1 {
    fun uniquePaths(m: Int, n: Int): Int {
        var prev = IntArray(n) { 1 }
        val cur = IntArray(n) { 1 }

        for (row in 1 until m) {
            for (col in 1 until n) {
                cur[col] = prev[col] + cur[col - 1]
            }

            prev = cur
        }

        return prev[n - 1]
    }
}