package com.example.androidbootcamp2021

fun main() {
    // Q1 Write a program to print your Firstname, LastName & age using init block,companion object.
    println("Q1")
    // Making Object of class
    val ob1 = Q1()
    // calling method
    ob1.printDetails()

    // printing details from Companion object
    println("\nValue initialised from companion object")
    println("First name: ${Q1.fname}")
    println("Last name: ${Q1.lname}")
    println("Age: ${Q1.age}")
}