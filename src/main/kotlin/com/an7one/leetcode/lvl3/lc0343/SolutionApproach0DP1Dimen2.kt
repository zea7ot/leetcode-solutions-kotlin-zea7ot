/**
 * https://leetcode.com/problems/integer-break/
 *
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(`n`)
 *
 * References:
 *  https://leetcode.com/problems/integer-break/discuss/80694/Java-DP-solution/85257
 */
package com.an7one.leetcode.lvl3.lc0343

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen2 {
    fun integerBreak(n: Int): Int {
        val dp = IntArray(n + 1) { 0 }
        for (hi in 2..n) {
            dp[hi - 1] = maxOf(hi - 1, dp[hi - 1])
            var lo = 1
            while (2 * lo <= hi) {
                dp[hi] = maxOf(dp[hi], dp[lo] * dp[hi - lo])
                ++lo
            }
        }

        return dp[n]
    }
}