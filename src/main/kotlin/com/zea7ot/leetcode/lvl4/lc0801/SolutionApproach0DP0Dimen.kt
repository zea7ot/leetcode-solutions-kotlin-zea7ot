/**
 * https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/discuss/119879/C++JavaPython-DP-O(N)-Solution/561174
 *  https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/discuss/119879/C%2B%2BJavaPython-DP-O(N)-Solution
 */
package com.zea7ot.leetcode.lvl4.lc0801

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP0Dimen {
    fun minSwap(A: IntArray, B: IntArray): Int {
        val totalNums = A.size
        // base cases
        var prevSwap = 1
        var prevNotSwap = 0

        for (idx in 1 until totalNums) {
            var swap = totalNums
            var notSwap = totalNums

            if (A[idx - 1] < A[idx] && B[idx - 1] < B[idx]) {
                swap = prevSwap + 1
                notSwap = prevNotSwap
            }

            if (A[idx - 1] < B[idx] && B[idx - 1] < A[idx]) {
                swap = minOf(swap, prevNotSwap + 1)
                notSwap = minOf(notSwap, prevSwap)
            }

            prevSwap = swap
            prevNotSwap = notSwap
        }

        return minOf(prevSwap, prevNotSwap)
    }
}