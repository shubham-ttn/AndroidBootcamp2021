package com.example.androidbootcamp2021

// Write a program to print your Firstname, LastName & age using init block,companion object.

class Q1 {

    // Companion object make it public static
    // So we can access it just as using ClassName.propertyName
    companion object {
        const val fname = "Gaurav"
        const val lname = "Rawat"
        const val age = 25
    }

    var fname: String? = null
    var lname: String? = null
    var age: String? = null

    // init will initialise values
    init {
        fname = "Shubham"
        lname = "Pandey"
        age = "23"

    }

    // init will initialise details
    // then we will print it
    fun printDetails() {
        println("Value initialised from init block")
        println("First name: $fname")
        println("Last name: $lname")
        println("Age: $age")
    }

}