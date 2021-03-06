/**
 * https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * References:
 *  https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/discuss/780887/Java-Detailed-Explanation-DPMapPrefix-O(N)
 */
package com.an7one.leetcode.lvl4.lc1546

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0PrefixSums {
    fun maxNonOverlapping(nums: IntArray, target: Int): Int {
        // not used
        // val nNums = nums.size

        val freqs = hashMapOf(0 to 0)

        var max = 0
        var sum = 0

        for (num in nums) {
            sum += num

            freqs[sum - target]?.let {
                max = maxOf(max, 1 + it)
            }

            freqs[sum] = max
        }

        return max
    }
}