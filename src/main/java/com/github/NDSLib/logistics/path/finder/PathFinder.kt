package com.github.NDSLib.logistics.path.finder

import com.github.NDSLib.logistics.node.Node
import com.github.NDSLib.logistics.path.Path

/**
 * Pathfinder interface.
 */
interface PathFinder<D, N : Node<D>> {
    /**
     * Finding path from start to end.
     */
    fun findPath(start: N, end: N): List<Path<D, N>>
}

class PathFinderException(message: String) : Exception(message)
class PathCirculationException(occurredNodes:List<Node<*>>) : Exception("Circulation detected,Nodes:$occurredNodes")