package com.example.mockktestapp.utils

import io.mockk.*
import org.junit.Test

import org.junit.Assert.*

class CallbackUtilsTest {

    @Test
    fun run() {
        val slot = slot<String>()

        val callback = mockk<(String) -> Unit>()

        every {
            callback.invoke(capture(slot))
        } just runs

        CallbackUtils(callback).run("abc")

        assertEquals("abc", slot.captured)
    }
}