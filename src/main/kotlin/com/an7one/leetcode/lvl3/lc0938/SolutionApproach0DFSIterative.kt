/**
 * https://leetcode.com/problems/range-sum-of-bst/
 */
package com.an7one.leetcode.lvl3.lc0938

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0DFSIterative {
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        var sum = 0

        val stack = LinkedList<TreeNode>()
        stack.push(root)

        while (stack.isNotEmpty()) {
            val top = stack.pop()

            val value = top.`val`

            if (value >= low) {
                top.left?.let { stack.push(it) }
            }

            if (value <= high) {
                top.right?.let { stack.push(it) }
            }

            if (value in low..high) {
                sum += value
            }
        }

        return sum
    }
}