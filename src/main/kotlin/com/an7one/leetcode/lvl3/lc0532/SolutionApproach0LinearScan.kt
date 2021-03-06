/**
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/
 *
 * Time  Complexity:    O(N * lg(N))
 * Space Complexity:    O(N)
 */
package com.an7one.leetcode.lvl3.lc0532

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun findPairs(nums: IntArray, k: Int): Int {
        // sanity check
        if (nums.isEmpty()) return 0

        nums.sort()

        val pool = HashSet<Int>()
        val ans = HashSet<Int>()

        for (num in nums) {
            if (pool.contains(num)) ans.add(num)

            pool.add(num + k)
        }

        return ans.size
    }
}