/**
 * https://leetcode.com/problems/powx-n/
 *
 * Time Complexity:     O(lg(`n`))
 * Space Complexity:    O(lg(`n`))
 *
 * References:
 *  https://youtu.be/SWr4cSY2fCk?t=671
 */
package com.an7one.leetcode.lvl3.lc0050

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DivideAndConquer1 {
    fun myPow(x: Double, n: Int): Double {
        return when {
            x == 0.0 || x == 1.0 -> x
            n < 0 -> 1 / pow(x, -n)
            else -> pow(x, n)
        }
    }

    private fun pow(x: Double, n: Int): Double {
        if (n == 0) return 1.0
        val y = pow(x, n / 2)
        return if (n % 2 == 0) y * y
        else y * y * x
    }
}