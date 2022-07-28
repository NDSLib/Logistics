package com.github.NDSLib.logistics.path

import com.github.NDSLib.logistics.node.Node
import com.github.NDSLib.logistics.node.NodeRef

/**
 * This class express the path from one node to another node.
 */
interface Path {
    fun startNode(): Node
    fun endNode(): Node
    fun path(): List<NodeRef>
}