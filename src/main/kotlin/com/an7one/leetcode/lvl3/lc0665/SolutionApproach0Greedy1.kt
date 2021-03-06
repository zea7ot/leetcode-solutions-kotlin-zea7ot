/**
 * https://leetcode.com/problems/non-decreasing-array/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/non-decreasing-array/discuss/106849/C%2B%2B-Java-Clean-Code-6-liner-Without-Modifying-Input
 */
package com.an7one.leetcode.lvl3.lc0665

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy1 {
    fun checkPossibility(nums: IntArray): Boolean {
        val totalNums = nums.size

        var modified = 0
        var prev = nums[0]

        for (i in 1 until totalNums) {
            if (prev > nums[i]) {
                if (++modified > 1) return false

                if (i - 2 >= 0 && nums[i - 2] > nums[i]) continue
            }

            prev = nums[i]
        }

        return true
    }
}