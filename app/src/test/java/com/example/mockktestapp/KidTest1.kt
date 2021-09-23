package com.example.mockktestapp

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Created by mark on 2021/9/21
 */
class KidTest1 {
    @MockK
    lateinit var mother: Mother

    @Before
    fun setup(){
        // 初始化后可用注解如（@MockK）
        MockKAnnotations.init(this)
    }

    @Test
    fun wantMoney() {
        every {
            mother.giveMoney()
        } returns 20

        val kid = Kid(mother)

        assertEquals(0, kid.money)
        kid.wantMoney()
        assertEquals(20, kid.money)
    }
}
