package com.example.mockktestapp.refactor

/**
 * Created by mark on 2021/9/25
 */
data class Doc(
    val name: String = "Asia",
    val demand: Int = 30,
    val price: Int = 20,
    val producers: List<Producer> = mutableListOf(
        Producer(name = "Byzantium", cost = 10, production = 9),
        Producer(name = "Attalia", cost = 12, production = 10),
        Producer(name = "Sinope", cost = 10, production = 6)
    )
)