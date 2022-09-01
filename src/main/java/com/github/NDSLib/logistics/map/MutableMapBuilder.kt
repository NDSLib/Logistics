package com.github.NDSLib.logistics.map

import com.github.NDSLib.logistics.node.Node

class MutableMapBuilder<N : Node<D>,D> {
    private var start: N? = null

    fun startNode(startNode: N) {
        this.start = startNode
    }

    fun build(): MutableMap<D,N> {
        if (start == null) {
            throw IllegalArgumentException("Start node is not set")
        } else {
            return MutableMap<D,N>().also { it.addNode(start!!) }
        }
    }
}