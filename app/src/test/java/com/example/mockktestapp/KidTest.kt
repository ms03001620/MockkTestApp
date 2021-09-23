package com.example.mockktestapp

import io.mockk.*
import org.junit.Test

import org.junit.Assert.*

/**
 * https://medium.com/joe-tsai/mockk-%E4%B8%80%E6%AC%BE%E5%BC%B7%E5%A4%A7%E7%9A%84-kotlin-mocking-library-part-4-4-f82443848a3a
 */
class KidTest {

    @Test
    fun wantMoney() {
        val mother = mockk<Mother>()

        every {
            mother.giveMoney()
        } returns 20

        val kid = Kid(mother)

        assertEquals(0, kid.money)
        kid.wantMoney()
        assertEquals(20, kid.money)
    }

    @Test
    fun wantMoneyNoti() {
        val mother = mockk<Mother>()

        every {
            mother.giveMoney()
        } returns 20

        every { mother.inform(any()) } just Runs

        val kid = Kid(mother)

        assertEquals(0, kid.money)
        kid.wantMoneyNoti()
        verify { mother.inform(any()) }
        assertEquals(20, kid.money)
    }

    @Test
    fun wantMoneyNotiRelaxed() {
        val mother = mockk<Mother>(relaxed = true)
        val kid = Kid(mother)

        kid.wantMoneyNoti()
        verify {
            mother.inform(any())
            mother.giveMoney()
        }
    }

    @Test
    fun wantMoneyNotiRelaxedFun() {
        //relaxUnitFun 无返回值可以忽略，有返回值还需要设置returns
        val mother = mockk<Mother>(relaxUnitFun = true)
        val kid = Kid(mother)

        every {
            mother.giveMoney()
        } returns 20

        kid.wantMoneyNoti()
        verify {
            mother.inform(any())
            mother.giveMoney()
        }
        assertEquals(20, kid.money)

    }

    @Test
    fun wantMoneyNotiRelaxedFunOrder() {
        val mother = mockk<Mother>(relaxed = true)
        val kid = Kid(mother)
        kid.wantMoneyNoti()

        // 强调顺序调用，不可有穿插
        verifySequence {
            mother.inform(any())
            mother.giveMoney()
        }

        // 强调顺序，可以之间可以有其他语句
        verifyOrder {
            mother.inform(any())
            mother.giveMoney()
        }
    }

    @Test
    fun wantMoneyNotiSlot(){
        val mother = mockk<Mother>(relaxed = true)

        val kid = Kid(mother)
        kid.money = 50

        val slot = slot<Int>()
        every { mother.inform(capture(slot)) } just Runs

        kid.wantMoneyNoti()
        assertEquals(50, slot.captured)
    }
}