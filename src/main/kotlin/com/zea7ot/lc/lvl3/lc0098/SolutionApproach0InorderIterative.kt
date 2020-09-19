/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/validate-binary-search-tree/discuss/32112/Learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-(Java-Solution)
 */
package com.zea7ot.lc.lvl3.lc0098

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.lc.utils.data_structure.tree.TreeNode
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0InorderIterative {
    fun isValidBST(root: TreeNode?): Boolean {
        // sanity check
        if (root == null) return true

        var prev: Int? = null

        val stack = LinkedList<TreeNode>()
        pushLeft(root, stack)
        while (stack.isNotEmpty()) {
            val top = stack.pop()

            prev?.let { if (it >= top.`val`) return false }
            prev = top.`val`

            pushLeft(top.right, stack)
        }

        return true
    }

    private fun pushLeft(node: TreeNode?, stack: LinkedList<TreeNode>) {
        var cur = node
        while (cur != null) {
            stack.push(cur)
            cur = cur.left
        }
    }
}