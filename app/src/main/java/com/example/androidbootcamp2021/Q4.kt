package com.example.androidbootcamp2021

// WAP to create extension function.

class Q4 {
    val num1: Int = 10

    val str1 = "Kotlin"
    val str2 = "World!"

    // Extension function
    // Adding functionality to existing
    // Int class
    fun Int.Addition(num2: Int): Int {
        return this+num2
    }

    // Extension function
    // Adding functionality to existing
    // String class
    fun String.returnRemovedSpace(s: String, s1: String): String {
        return this + s + s1
    }

    fun printDetails() {
        println("Addition of 5 and 10: " + 5.Addition(num1))
        println("After removing spaces from string Hello Kotlin World!: " + "Hello".returnRemovedSpace(str1, str2))

    }
}