/**
 * https://leetcode.com/problems/house-robber-iii/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(N) + O(H) ~ O(N)
 *
 * References:
 *  https://leetcode.com/problems/partition-to-k-equal-sum-subsets/discuss/108730/javacstraightforward-dfs-solution
 */
package com.zea7ot.lc.lvl4.lc0337

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.lc.utils.data_structure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0DFSMemo1 {
    fun rob(root: TreeNode?): Int {
        return dfs(root, HashMap())
    }

    private fun dfs(node: TreeNode?, memo: HashMap<TreeNode, Int>): Int {
        var res = 0
        node?.let {
            memo[it]?.let { `val` -> return `val` }

            it.left?.let { left ->
                res += dfs(left.left, memo) + dfs(left.right, memo)
            }

            it.right?.let { right ->
                res += dfs(right.left, memo) + dfs(right.right, memo)
            }

            res = maxOf(res + it.`val`, dfs(it.left, memo) + dfs(it.right, memo))
        }

        return res
    }
}