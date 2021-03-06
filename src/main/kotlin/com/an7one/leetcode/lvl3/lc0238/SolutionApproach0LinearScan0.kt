/**
 * https://leetcode.com/problems/product-of-array-except-self/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`) / O(1)
 */
package com.an7one.leetcode.lvl3.lc0238

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan0 {
    fun productExceptSelf(nums: IntArray): IntArray {
        val nNums = nums.size
        val ans = IntArray(nNums) { 0 }

        var prevProduct = 1
        for (idx in 0 until nNums) {
            ans[idx] = prevProduct
            prevProduct *= nums[idx]
        }

        prevProduct = 1
        for (idx in nNums - 1 downTo 0) {
            ans[idx] *= prevProduct
            prevProduct *= nums[idx]
        }

        return ans
    }
}