package com.example.mockktestapp


class Kid(private val mother: Mother) {
    var money = 0
        set

    fun wantMoney() {
        money += mother.giveMoney()
    }

    fun wantMoneyNoti() {
        mother.inform(money)
        money += mother.giveMoney()
    }

}