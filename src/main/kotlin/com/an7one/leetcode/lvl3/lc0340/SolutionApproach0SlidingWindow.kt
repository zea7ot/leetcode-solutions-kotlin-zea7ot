/**
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(128) ~ O(1)
 *
 * Reference:
 *  https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/discuss/80047/15-lines-java-solution-using-slide-window
 */
package com.an7one.leetcode.lvl3.lc0340

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0SlidingWindow {
    fun lengthOfLongestSubstringKDistinct(str: String, k: Int): Int {
        val lenS = str.length
        val freqs = IntArray(128) { 0 }

        var lo = 0
        var hi = 0
        var distinct = 0
        var longest = 0

        while (hi < lenS) {
            if (freqs[str[hi].toInt()]++ == 0)
                ++distinct

            while (distinct > k) {
                if (--freqs[str[lo++].toInt()] == 0)
                    --distinct
            }

            longest = maxOf(longest, hi - lo + 1)
            ++hi
        }

        return longest
    }
}