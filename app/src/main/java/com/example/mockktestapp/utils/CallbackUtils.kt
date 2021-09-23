package com.example.mockktestapp.utils

class CallbackUtils(private val callback: (String) -> Unit) {
    fun run(string: String) {
        callback.invoke(string)
    }
}