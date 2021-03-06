/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/discuss/27976/3-6-easy-lines-C%2B%2B-Java-Python-Ruby
 */
package com.an7one.leetcode.lvl3.lc0080

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun removeDuplicates(nums: IntArray): Int {
        // not used
        // val nNums = nums.size

        var idx = 0
        for (num in nums) {
            if (idx < 2 || nums[idx - 2] < num) {
                nums[idx++] = num
            }
        }

        return idx
    }
}