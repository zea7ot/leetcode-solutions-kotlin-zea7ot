/**
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 *
 * Time Complexity:     O(`totalNums` ^ 2)
 * Space Complexity:    O(`totalNums`)
 *
 * References:
 *  https://leetcode.com/problems/number-of-longest-increasing-subsequence/discuss/107318/C%2B%2B-DP-with-explanation-O(n2)
 */
package com.zea7ot.lc.lvl4.lc0673

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun findNumberOfLIS(nums: IntArray): Int {
        // sanity check
        if (nums.isEmpty()) return 0

        val totalNums = nums.size
        val lens = IntArray(totalNums) { 1 }
        val counts = IntArray(totalNums) { 1 }

        var longest = 0

        for (hi in 0 until totalNums) {
            for (lo in 0 until hi) {
                if (nums[lo] < nums[hi]) {
                    if (lens[hi] == lens[lo] + 1) {
                        counts[hi] += counts[lo]
                    } else if (lens[hi] < lens[lo] + 1) {
                        lens[hi] = lens[lo] + 1
                        counts[hi] = counts[lo]
                    }
                }
            }

            longest = maxOf(longest, lens[hi])
        }

        var count = 0
        for (i in 0 until totalNums) {
            if (lens[i] == longest) {
                count += counts[i]
            }
        }

        return count
    }
}