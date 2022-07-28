package com.github.NDSLib.logistics.map

import com.github.NDSLib.logistics.node.Node

open class MutableMap : Map {
    fun addNode(node: Node) {
        nodes.add(node)
    }

    private val nodes = mutableListOf<Node>()

    override fun allNodes(): List<Node> {
        return nodes.toList()
    }
}