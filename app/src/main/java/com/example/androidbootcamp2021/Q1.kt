package com.example.androidbootcamp2021

// Q1 Write a program to replace a substring inside a string with another string.

fun replaceString() {
    val str1 = "Hello Boys"

    println("Original string: $str1")
    println("Replaced string: ${str1.replace("Boys", "World", true)}\n")
}

