package com.github.NDSLib.logistics.test.map

import com.github.NDSLib.logistics.map.MutableMapBuilder
import com.github.NDSLib.logistics.node.MutableNode
import org.junit.jupiter.api.Test

class GenerateMapTest {

    @Test
    fun generate() {
        val generator = MutableMapBuilder<MutableNode<Int>, Int>()
        val node1 = MutableNode(1)
        val node2 = MutableNode(2)
        val node3 = MutableNode(3)
        val node4 = MutableNode(4)

        node1.chain(node2)
        node2.chain(node3)
        node3.chain(node4)

        generator.startNode(node1)

        val map = generator.build()

        assert(map.allNodes()[0] == node1)
        assert(map.allNodes()[0].data == 1)
        assert(map.allNodes()[0].chainingNodes()[0] == node2)
        assert(map.allNodes()[0].chainingNodes()[0].data == 2)
        assert(map.allNodes()[0].chainingNodes()[0].chainingNodes()[0] == node3)
        assert(map.allNodes()[0].chainingNodes()[0].chainingNodes()[0].data == 3)
        assert(map.allNodes()[0].chainingNodes()[0].chainingNodes()[0].chainingNodes()[0] == node4)
        assert(map.allNodes()[0].chainingNodes()[0].chainingNodes()[0].chainingNodes()[0].data == 4)
    }
}