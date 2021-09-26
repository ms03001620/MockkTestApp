package com.example.mockktestapp.refactor

import org.junit.Assert.*
import org.junit.Test

class ProvinceTest {
    @Test
    fun testShortfall() {
        val p = Province(Doc())
        assertEquals(5, p.getShortfall())
    }

    @Test
    fun testProfit() {
        val p = Province(Doc())
        assertEquals(230, p.getProfit())
    }

    @Test
    fun testChangeValue() {
        val d = Doc()
        d.producers[0].production = 20

        val p = Province(d)
        assertEquals(-6, p.getShortfall())
        assertEquals(292, p.getProfit())
    }

    @Test
    fun testListEmpty() {
        val d = Doc(producers = emptyList())
        val p = Province(d)

        assertEquals(30, p.getShortfall())
        assertEquals(0, p.getProfit())
    }
}