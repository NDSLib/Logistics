package com.github.NDSLib.logistics.path

import com.github.NDSLib.logistics.node.Node
import com.github.NDSLib.logistics.path.finder.PathFinder

open class ImmutablePath<D, N : Node<D>>(
    private val nodes: List<N>
) : Path<D, N> {
    override fun startNode(): N {
        return nodes.first()
    }

    override fun endNode(): N {
        return nodes.last()
    }

    override fun nodes(): List<N> {
        return nodes
    }
}

fun <D, N : Node<D>> N.pathTo(to: N, pathFinder: PathFinder<D, N>): List<Path<D, N>> {
    return try {
        listOf(this.pathToNeighbour(to))
    } catch (e: IllegalArgumentException) {
        pathFinder.findPath(this, to)
    }
}

private fun <D, N : Node<D>> N.pathToNeighbour(to: N): ImmutablePath<D, N> {
    val node = this.chainingNodes().find { it == to } as? N ?: throw IllegalArgumentException("No path found")
    return ImmutablePath(listOf(this, node))
}