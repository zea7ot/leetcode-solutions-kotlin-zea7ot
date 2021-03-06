/**
 * https://leetcode.com/problems/jump-game-ii/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 *
 * to start with the last position, and find the leftmost start ever possible, in a implicit BFS way
 *
 * References:
 *  https://leetcode.com/problems/jump-game-ii/discuss/18028/O(n)-BFS-solution/237098
 */
package com.an7one.leetcode.lvl4.lc0045

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach1BFS {
    fun jump(nums: IntArray): Int {
        val totalNums = nums.size
        var destination = totalNums - 1
        var jump = 0

        while (destination > 0) {
            for (idx in 0 until destination) {
                if (idx + nums[idx] >= destination) {
                    destination = idx
                    ++jump
                    break
                }
            }
        }

        return jump
    }
}