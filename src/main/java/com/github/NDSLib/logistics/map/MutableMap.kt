package com.github.NDSLib.logistics.map

import com.github.NDSLib.logistics.node.Node
import com.github.NDSLib.logistics.path.Path

open class MutableMap<D,N : Node<D>> : Map<D,N> {
    fun addNode(node: N) {
        nodes.add(node)
    }

    private val nodes = mutableListOf<N>()

    override fun allNodes(): List<N> {
        return nodes.toList()
    }
}