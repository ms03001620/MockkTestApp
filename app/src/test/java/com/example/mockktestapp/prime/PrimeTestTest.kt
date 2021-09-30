package com.example.mockktestapp.prime

import org.junit.Test

import org.junit.Assert.*

class PrimeTestTest {

    @Test
    fun isPrime() {
        assertEquals(true, PrimeTest().isPrime(3))
    }
}