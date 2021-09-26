package com.example.mockktestapp.refactor

import java.lang.Math.min

class Province(val doc: Doc) {
    var _name: String
    val _producers = mutableListOf<Producer>()
    var _totalProduction = 0
    var _demand: Int
    var _price: Int

    init {
        _name = doc.name
        _demand = doc.demand
        _price = doc.price

        for (p in doc.producers) {
            addProducer(p)
        }
    }

    fun addProducer(producer: Producer) {
        _producers.add(producer)
        _totalProduction += producer.production
    }


    fun getProducers() = _producers.apply {
        if (isNotEmpty()) {
            slice(0..size)
        } else {
            emptyList<Producer>()
        }
    }

    fun getName() = _name
    fun getDemand() = _demand
    fun getPrice() = _price

    fun getShortfall(): Int = _demand - _totalProduction

    fun getDemandCost(): Int {
        var remainingDemand = this._demand
        var result = 0

        _producers.sortedBy {
            it.cost
        }.forEach { p ->
            min(remainingDemand, p.production).let {
                remainingDemand -= it
                result += it * p.cost
            }
        }
        return result
    }

    fun getProfit()  = getDemandValue() - getDemandCost()

    fun getDemandValue() = getSatisfiedDemand() * _price

    fun getSatisfiedDemand() = min(_demand, _totalProduction)
}