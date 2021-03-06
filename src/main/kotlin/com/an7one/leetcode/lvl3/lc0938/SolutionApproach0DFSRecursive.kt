/**
 * @author: Leon
 * https://leetcode.com/problems/range-sum-of-bst/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.an7one.leetcode.lvl3.lc0938

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int = dfs(low, high, root)

    private fun dfs(low: Int, high: Int, node: TreeNode?): Int {
        if (node == null) return 0

        var sum = 0

        val value = node.`val`

        if (value >= low) {
            sum += dfs(low, high, node.left)
        }

        if (value <= high) {
            sum += dfs(low, high, node.right)
        }

        if (value in low..high) {
            sum += value
        }

        return sum
    }
}