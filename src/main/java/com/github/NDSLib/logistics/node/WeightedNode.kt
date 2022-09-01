package com.github.NDSLib.logistics.node

/**
 * Node which is weighted.
 */
interface WeightedNode<N : Node<N>, R : Number> : Node<N> {
    fun weight(): R
}