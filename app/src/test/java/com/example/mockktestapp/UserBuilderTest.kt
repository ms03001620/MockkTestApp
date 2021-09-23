package com.example.mockktestapp

import io.mockk.CapturingSlot
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkConstructor
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by mark on 2021/9/22
 */
class UserBuilderTest {
    @Test
    fun testBuilderInit() {
        val buildResult = mockk<BuildResult>().also { buildResult ->
            every {
                buildResult.inject(any())
            } answers {
                firstArg<UserBuilder>().data = "abc"
            }
        }

        mockkConstructor(PartBuilder.Builder::class)
        every {
            anyConstructed<PartBuilder.Builder>().build()
        }.returns(buildResult)

        assertEquals("abc", UserBuilder().data)
    }

    @Test
    fun testBuilderInit2() {
        val buildResult = mockk<BuildResult>().also { buildResult ->
            CapturingSlot<UserBuilder>().let { slot ->
                every {
                    buildResult.inject(capture(slot))
                } answers {
                    slot.captured.data = "abcd"
                }
            }
        }

        mockkConstructor(PartBuilder.Builder::class)
        every {
            anyConstructed<PartBuilder.Builder>().build()
        }.returns(buildResult)

        assertEquals("abcd", UserBuilder().data)
    }
}