package com.example.androidbootcamp2021

// Write a program to create mutable list of Integer. replace the second item in the list with
// new value. Print the list value.

class Q6 {
    val mList = mutableListOf<Int>(1, 8, 3, 4)

    fun replaceSecondItem() {
        mList[1]  = 2
        printList()
    }

    private fun printList() {
        println("Updated content in list: $mList")
    }
}