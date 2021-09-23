package com.example.mockktestapp

/**
 * Created by mark on 2021/9/22
 */
class UserBuilder {

    lateinit var data: String

    init {
        PartBuilder
            .builder()
            .setApplication(null)
            .build()
            .inject(this)
    }
}