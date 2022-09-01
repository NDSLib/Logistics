package com.github.NDSLib.logistics.node

open class MutableNode<N>(var data: N) : Node<N> {
    fun chain(to: MutableNode<N>) {
        chaining.add(to)
    }

    private val chaining = mutableListOf<MutableNode<N>>()

    override fun chainingNodes(): List<MutableNode<N>> {
        return chaining.toList()
    }

    override fun data(): N = data
}