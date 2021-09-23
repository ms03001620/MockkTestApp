package com.example.mockktestapp

import org.junit.Assert.*
import org.junit.Test

class MotherTest {
    @Test
    fun testMother() {
        assertEquals(100, Mother().giveMoney())
    }
}