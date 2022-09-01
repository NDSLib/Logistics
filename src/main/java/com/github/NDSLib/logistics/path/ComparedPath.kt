package com.github.NDSLib.logistics.path

import com.github.NDSLib.logistics.node.Node
import com.github.NDSLib.logistics.node.NodeRef

/**
 * Path implementation that uses a list of nodes to represent the path.
 */
class ComparedPath<D,N : Node<D>>(val paths: List<Path<D,N>>) : Path<D,N> {
    override fun startNode(): N {
        return paths.first().startNode()
    }

    override fun endNode(): N {
        return paths.last().endNode()
    }

    override fun refs(): List<NodeRef<D,N>> {
        return paths.flatMap { it.refs() }
    }
}

operator fun <D,N : Node<D>> Path<D,N>.plus(other: Path<D,N>): Path<D,N> {
    return ComparedPath(listOf(this, other))
}

fun <D,N : Node<D>> Path<D,N>.plus(vararg others: Path<D,N>): Path<D,N> {
    return ComparedPath(listOf(this) + others.toList())
}