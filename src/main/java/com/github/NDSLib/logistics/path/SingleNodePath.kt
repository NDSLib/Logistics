package com.github.NDSLib.logistics.path

import com.github.NDSLib.logistics.node.Node
import com.github.NDSLib.logistics.node.NodeRef

class SingleNodePath<D, N : Node<D>>(private val n: N) : Path<D,N> {
    override fun startNode(): N = n

    override fun endNode(): N = n

    override fun refs(): List<NodeRef<D,N>> = listOf()
}