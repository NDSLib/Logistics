package com.github.NDSLib.logistics.test.map

import com.github.NDSLib.logistics.map.MutableMapBuilder
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals

class GenerateMapTest {

    @Test
    fun generate() {
        val generator = MutableMapBuilder()
        generator.startNode().apply {
            chain().apply {
                chain()
                chain()
                chain()
            }

            chain().apply {
                chain()
            }
        }

        val map = generator.build()

        assertAll(
            { assertEquals(1, map.allNodes().size) },
            { assertEquals(3, map.allNodes()[0].chainingNodes()[0].getNode().chainingNodes().size) },
            { assertEquals(1, map.allNodes()[0].chainingNodes()[1].getNode().chainingNodes().size) },
        )
    }
}