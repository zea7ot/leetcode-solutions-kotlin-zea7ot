/**
 * https://leetcode.com/problems/network-delay-time/
 *
 * Time Complexity:     O(E * lg(V)) ~ O(`nTimes` * lg(`nNodes`))
 * Space Complexity:    O()
 *
 * References:
 *
 */
package com.zea7ot.leetcode.lvl3.lc0743

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0DijkstraSPF {
    private companion object {
        private const val DATA_RANGE = 100 + 1
    }

    fun networkDelayTime(times: Array<IntArray>, nNodes: Int, start: Int): Int {
        // not used
        // val nTimes = times.size

        val graph = buildGraph(times, nNodes)

        val minHeap = PriorityQueue<State>(compareBy { it.time }).also {
            it.offer(State(start - 1, 0))
        }

        val seen = HashSet<Int>()
        var steps = 0

        while (minHeap.isNotEmpty()) {
            val (curNode, curTime) = minHeap.poll()

            if (!seen.add(curNode)) continue

            for ((nextNode, nextTime) in graph[curNode]) {
                minHeap.offer(State(nextNode, nextTime + curTime))
            }

            if (++steps == nNodes) return curTime
        }

        return -1
    }

    private fun buildGraph(times: Array<IntArray>, nNodes: Int): List<List<State>> {
        val graph = List(nNodes) { mutableListOf<State>() }

        for ((start, end, time) in times) {
            graph[start - 1].add(State(end - 1, time))
        }

        return graph
    }

    private data class State(val nodeID: Int, val time: Int)
}