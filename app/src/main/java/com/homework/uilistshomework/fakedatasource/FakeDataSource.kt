package com.homework.uilistshomework.fakedatasource

import com.homework.uilistshomework.Item

object FakeDataSource {
    fun getCars(): List<Item.Car> {
        return listOf(
            Item.Car("Honda accord", "green"),
            Item.Car("LADA 4x4", "brown"),
            Item.Car("Great wall HOVER", "black")
        )
    }

    fun getMotorcycles(): List<Item.Motorcycle> {
        return listOf(
            Item.Motorcycle("Honda CB 400", "Classic"),
            Item.Motorcycle("Honda VT 1100", "Cruiser"),
            Item.Motorcycle("Triumph Tiger", "Tourist")
        )
    }

    fun getTaxies(): List<Item.Taxi> {
        return listOf(
            Item.Taxi("SATURN", "A785AB52"),
            Item.Taxi("CITYMOBIL", "O209MA52"),
            Item.Taxi("UBER", "P911KE799"),
        )
    }

    fun getCarsAndMotorcycles(): List<Item> {
        val list = mutableListOf<Item>()
        list.addAll(getCars())
        list.addAll(getMotorcycles())
        list.shuffle()
        return list.toList()
    }

}