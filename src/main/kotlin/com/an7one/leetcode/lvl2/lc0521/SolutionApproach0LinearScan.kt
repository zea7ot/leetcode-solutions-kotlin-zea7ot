/**
 * https://leetcode.com/problems/longest-uncommon-subsequence-i/
 *
 * Time Complexity:     O(min(lenA, lenB))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/longest-uncommon-subsequence-i/discuss/99409/Java-1-liner
 */
package com.an7one.leetcode.lvl2.lc0521

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun findLUSLength(a: String, b: String): Int {
        return if (a == b) -1 else maxOf(a.length, b.length)
    }
}