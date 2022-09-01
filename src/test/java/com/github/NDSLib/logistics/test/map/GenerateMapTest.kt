package com.github.NDSLib.logistics.test.map

import com.github.NDSLib.logistics.map.MutableMap
import com.github.NDSLib.logistics.map.MutableMapBuilder
import com.github.NDSLib.logistics.node.MutableNode
import org.junit.jupiter.api.Test

class GenerateMapTest {
    @Test
    fun generate() {
        val map = testGenMap().first

        assert(map.allNodes()[0].data == 1)
        assert(map.allNodes()[0].chainingNodes()[0].data == 2)
        assert(map.allNodes()[0].chainingNodes()[0].chainingNodes()[0].data == 3)
        assert(map.allNodes()[0].chainingNodes()[0].chainingNodes()[1].data == 22)
        assert(map.allNodes()[0].chainingNodes()[0].chainingNodes()[0].chainingNodes()[0].data == 4)
    }
}

/**
 * Generate Map:
 *  node1 -> node2 -> node3 -> node4
 *                 -> node22 -> node4
 */
fun testGenMap(): Pair<MutableMap<Int, MutableNode<Int>>, Pair<MutableNode<Int>, MutableNode<Int>>> {
    val generator = MutableMapBuilder<MutableNode<Int>, Int>()
    val node1 = MutableNode(1)
    val node2 = MutableNode(2)
    val node22 = MutableNode(22)
    val node3 = MutableNode(3)
    val node4 = MutableNode(4)

    node1.chain(node2)
    node2.chain(node3)
    node3.chain(node4)
    node2.chain(node22)
    node22.chain(node4)

    generator.startNode(node1)

    return generator.build() to (node1 to node4)
}