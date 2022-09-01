package com.github.NDSLib.logistics.path

import com.github.NDSLib.logistics.node.Node
import com.github.NDSLib.logistics.node.NodeRef

/**
 * This class express the path from one node to another node.
 */
interface Path<D,N : Node<D>> {
    /**
     * Get the node at the start of the path.
     */
    fun startNode(): N

    /**
     * Get the node at the end of the path.
     */
    fun endNode(): N

    /**
     * Get all Node in the path.
     */
    fun nodes():List<N>
}