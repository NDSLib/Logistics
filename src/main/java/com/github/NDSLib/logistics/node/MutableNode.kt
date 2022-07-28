package com.github.NDSLib.logistics.node

open class MutableNode : Node {
    fun chain(to: Node) {
        refs.add(ImmutableNodeRef(to))
    }

    private val refs = mutableListOf<NodeRef>()

    override fun chainingNodes(): List<NodeRef> {
        return refs.toList()
    }
}