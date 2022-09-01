package com.github.NDSLib.logistics.node

/**
 * This class is expressing the node of the map.
 * In practice, this class expresses the intersection or the junction.
 */
interface Node<D> {
    fun chainingNodes(): List<Node<D>>

    /**
     * @return the data of this node.
     */
    fun data(): D
}