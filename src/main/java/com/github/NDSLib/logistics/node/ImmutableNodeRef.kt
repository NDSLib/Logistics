package com.github.NDSLib.logistics.node

open class ImmutableNodeRef(private val toNode: Node) : NodeRef {
    override fun getNode(): Node {
        return toNode
    }
}