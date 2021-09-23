package com.example.mockktestapp.utils


class RateUtils {

    private fun getRate(): Int {
        return 5
    }

    fun calculate(value: Int): Int {
        return getRate() * value
    }
}