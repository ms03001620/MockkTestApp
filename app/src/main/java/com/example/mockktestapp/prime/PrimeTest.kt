package com.example.mockktestapp.prime

import java.math.BigInteger

class PrimeTest {
    //https://hg.openjdk.java.net/jdk8/jdk8/jdk/file/tip/src/share/classes/java/math/BigInteger.java
    fun isPrime(number: Int): Boolean {
        val bigInt: BigInteger = BigInteger.valueOf(number.toLong())
        return bigInt.isProbablePrime(100)
    }
}