package com.github.NDSLib.logistics.node

/**
 * This class is expressing the node of the map.
 * In practice, this class expresses the intersection or the junction.
 */
interface Node {
    fun chainingNodes(): List<NodeRef>
}