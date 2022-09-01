package com.github.NDSLib.logistics.path.finder

import com.github.NDSLib.logistics.node.Node
import com.github.NDSLib.logistics.path.Path

/**
 * Pathfinder interface.
 */
interface PathFinder<D,N : Node<D>> {
    fun findPath(start: N, end: N): List<Path<D,N>>
}