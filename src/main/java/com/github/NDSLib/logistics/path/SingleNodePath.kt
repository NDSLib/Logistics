package com.github.NDSLib.logistics.path

import com.github.NDSLib.logistics.node.Node

class SingleNodePath<D, N : Node<D>>(private val n: N) : Path<D, N> {
    override fun startNode(): N = n

    override fun endNode(): N = n

    override fun nodes(): List<N> = listOf(n)
}