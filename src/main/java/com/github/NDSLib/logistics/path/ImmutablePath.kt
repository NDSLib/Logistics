package com.github.NDSLib.logistics.path

import com.github.NDSLib.logistics.node.ImmutableNodeRef
import com.github.NDSLib.logistics.node.Node
import com.github.NDSLib.logistics.node.NodeRef
import com.github.NDSLib.logistics.path.finder.PathFinder

open class ImmutablePath<D,N : Node<D>>(
    private val start: N,
    private val end: N,
    private val path: List<NodeRef<D,N>>
) : Path<D,N> {
    override fun startNode(): N {
        return start
    }

    override fun endNode(): N {
        return end
    }

    override fun refs(): List<NodeRef<D,N>> {
        return path
    }
}

fun <D,N : Node<D>> N.pathTo(to: N, pathFinder: PathFinder<D,N>): List<Path<D,N>> {
    return try {
        listOf(this.pathToNeighbour(to))
    } catch (e: IllegalArgumentException) {
        pathFinder.findPath(this, to)
    }
}

private fun <D,N : Node<D>> N.pathToNeighbour(to: N): ImmutablePath<D,N> {
    val node = this.chainingNodes().find { it == to } as? N ?: throw IllegalArgumentException("No path found")
    return ImmutablePath(this, to, listOf(ImmutableNodeRef<D,N>(this, node)))
}