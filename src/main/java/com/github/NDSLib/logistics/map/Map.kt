package com.github.NDSLib.logistics.map

import com.github.NDSLib.logistics.node.Node

/**
 * This class expresses the collection of nodes,noderefs.
 */
interface Map {
    fun allNodes(): List<Node>
}