package com.github.NDSLib.logistics.path.finder

import com.github.NDSLib.logistics.node.Node
import com.github.NDSLib.logistics.path.Path
import com.github.NDSLib.logistics.path.SingleNodePath
import com.github.NDSLib.logistics.path.plus

/**
 * A pathfinder that finds a path between two nodes.
 */
class StackPathFinder<D, N : Node<D>> : PathFinder<D, N> {
    override fun findPath(start: N, end: N): List<Path<D, N>> {
        if (start == end) {
            return listOf(SingleNodePath(start))
        }
        return start.chainingNodes().map { findPath(it as N, end) }.flatten()
            .filterNot { it.nodes().any { n -> n == start } }
            .map { p -> SingleNodePath(start) + p }
    }
}