package com.github.NDSLib.logistics.node

/**
 * Node which is weighted.
 */
interface WeightedNode<D : Number, N : Node<D>> : Node<D> {
    fun weight(): D = data()
}