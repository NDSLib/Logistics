package com.github.NDSLib.logistics.path

import com.github.NDSLib.logistics.node.MutableNode
import com.github.NDSLib.logistics.node.Node
import com.github.NDSLib.logistics.node.NodeRef

open class ImmutablePath(
    private val start: MutableNode,
    private val end: MutableNode,
    private val path: List<NodeRef>
) : Path {
    override fun startNode(): Node {
        return start
    }

    override fun endNode(): Node {
        return end
    }

    override fun path(): List<NodeRef> {
        return path
    }
}