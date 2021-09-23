package com.example.mockktestapp.utils

import io.mockk.every
import io.mockk.spyk
import org.junit.Test

import org.junit.Assert.*

class RateUtilsTest {

    @Test
    fun calculate() {
        val spyUtil = spyk<RateUtils>(recordPrivateCalls = true)
        every { spyUtil["getRate"]() }.returns(10)
        val expected = spyUtil.calculate(100)
        assertEquals(1000, expected)
    }
}