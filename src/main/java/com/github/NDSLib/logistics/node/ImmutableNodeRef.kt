package com.github.NDSLib.logistics.node

open class ImmutableNodeRef<D,N : Node<D>>(private val fromNode: N, private val toNode: N) : NodeRef<D,N> {
    override fun from(): N = fromNode
    override fun to(): N = toNode
}