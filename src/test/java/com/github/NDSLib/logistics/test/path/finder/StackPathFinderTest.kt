package com.github.NDSLib.logistics.test.path.finder

import com.github.NDSLib.logistics.map.MutableMapBuilder
import com.github.NDSLib.logistics.node.MutableNode
import com.github.NDSLib.logistics.path.finder.StackPathFinder
import com.github.NDSLib.logistics.test.map.testGenMap
import org.junit.jupiter.api.Test

class StackPathFinderTest {
    @Test
    fun test() {
        val map = testGenMap()
        val pathFinder = StackPathFinder<Int, MutableNode<Int>>()
        val pathList = pathFinder.findPath(map.second.first, map.second.second)

        assert(pathList.size == 2)
    }

    @Test
    fun circulationTest() {
        val builder = MutableMapBuilder<MutableNode<Int>, Int>()
        val node1 = MutableNode(1)
        val node2 = MutableNode(2)
        node1.chain(node2)
        node2.chain(node1)
        builder.startNode(node1)
        val map = builder.build()
        val pathFinder = StackPathFinder<Int, MutableNode<Int>>()
        assert(pathFinder.findPath(node1, node2).size == 1)
    }
}