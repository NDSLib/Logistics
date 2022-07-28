package com.github.NDSLib.logistics.map

import com.github.NDSLib.logistics.node.MutableNode

class MutableMapBuilder {
    private val start = BuildNode()

    fun startNode() = start

    fun build(): MutableMap {
        return MutableMap().also { it.addNode(start) }
    }

    class BuildNode : MutableNode() {
        fun chain(): BuildNode {
            val node = BuildNode()
            this.chain(node)
            return node
        }
    }
}