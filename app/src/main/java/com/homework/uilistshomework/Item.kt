package com.homework.uilistshomework

sealed class Item {
    data class Motorcycle(val name: String, val type: String) : Item()
    data class Car(val name: String, val color: String) : Item()
    data class Taxi(val name: String, val number: String) : Item()
}
