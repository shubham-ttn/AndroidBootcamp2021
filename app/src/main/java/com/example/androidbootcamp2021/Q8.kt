package com.example.androidbootcamp2021

// Write a program to create HasSet. print all the value.

class Q8 {
    // The HashSet class store elements using hashing mechanism.
    // It does not support duplicate value and does not make guarantees about the order sequence of element.
    val hashSet = hashSetOf("One", "Two", "Three", "Four")

    fun printHashSet() {
        println("Values in HashSet are: $hashSet")
    }
}