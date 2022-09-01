package com.github.NDSLib.logistics.map

import com.github.NDSLib.logistics.node.Node

/**
 * This class expresses the collection of nodes,noderefs.
 */
interface Map<D,N:Node<D>> {
    fun allNodes(): List<N>
}