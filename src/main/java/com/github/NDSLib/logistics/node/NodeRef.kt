package com.github.NDSLib.logistics.node

/**
 * This class express the ref between one node and another node.
 * This class is similar to the path, but this expresses only the relation between two nodes connecting each other.
 */
interface NodeRef {
    fun getNode(): Node
}