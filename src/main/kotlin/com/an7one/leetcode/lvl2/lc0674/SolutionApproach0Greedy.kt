/**
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 *
 * Time Complexity:     O(`totalSize`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/longest-continuous-increasing-subsequence/discuss/107365/JavaC%2B%2BClean-solution
 */
package com.an7one.leetcode.lvl2.lc0674

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun findLengthOfLCIS(nums: IntArray): Int {
        // sanity check
        if (nums.isEmpty()) return 0

        val totalSize = nums.size

        var longest = 1
        var len = 1

        for (i in 1 until totalSize) {
            if (i == 0 || nums[i - 1] < nums[i]) {
                longest = maxOf(longest, ++len)
            } else {
                len = 1
            }
        }

        return longest
    }
}