package com.homework.uilistshomework

enum class FragmentContentType(val value: Int) {
    TAXI(1), CARS_AND_MOTORCYCLES(2);

    companion object {
        fun create(x: Int): FragmentContentType {
            return when (x) {
                1 -> TAXI
                2 -> CARS_AND_MOTORCYCLES
                else -> throw IllegalStateException()
            }
        }
    }
}