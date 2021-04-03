/**
 * https://leetcode.com/problems/burst-balloons/
 *
 * Time Complexity:     O(`nNums` ^ 3)
 * Space Complexity:    O(`nNums` ^ 2)
 *
 * `dp[i][j]`, the maximum score with any one balloon within `nums[i : j]` bursted
 *
 * References:
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-312-burst-balloons/
 *  https://www.youtube.com/watch?v=z3hu2Be92UA
 *  https://youtu.be/FLbqgyJ-70I?t=7040
 */
package com.an7one.leetcode.lvl4.lc0312

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun maxCoins(nums: IntArray): Int {
        val nNums = nums.size

        // to pad both ends of `nums` array with 1
        val padded = IntArray(nNums + 2) { idx ->
            when (idx) {
                0 -> 1
                nNums + 1 -> 1
                else -> nums[idx - 1]
            }
        }

        val nPadded = padded.size

        val dp = Array(nPadded) { IntArray(nPadded) { 0 } }
        for (len in 1..nNums) {
            for (lo in 1 until nPadded - len) {
                val hi = lo + len - 1
                var maxCoins = 0

                for (k in lo..hi) {
                    maxCoins = maxOf(
                        maxCoins,
                        dp[lo][k - 1] + padded[lo - 1] * padded[k] * padded[hi + 1] + dp[k + 1][hi]
                    )
                }

                dp[lo][hi] = maxCoins
            }
        }

        return dp[1][nNums]
    }
}