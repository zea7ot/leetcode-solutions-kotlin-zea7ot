/**
 * https://leetcode.com/problems/merge-intervals/
 *
 * Time Complexity:     O(`nIntervals` * lg(`nIntervals`)) + O(`nIntervals`) ~ O(`nIntervals` * lg(`nIntervals`))
 * Space Complexity:    O(`nIntervals`)
 */
package com.an7one.leetcode.lvl3.lc0056

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        // not used
        // val nIntervals = intervals.size

        intervals.sortBy { it[0] }

        val merged = ArrayList<IntArray>()
        for (interval in intervals) {
            if (merged.isEmpty() || merged.last()[1] < interval[0]) {
                merged.add(interval)
            } else {
                merged.last()[1] = maxOf(merged.last()[1], interval[1])
            }
        }

        return merged.toTypedArray()
    }
}