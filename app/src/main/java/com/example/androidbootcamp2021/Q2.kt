package com.example.androidbootcamp2021

<<<<<<< Updated upstream
// Write a single program for following operation using overloading
// A) Adding 2 integer number
// B) Adding 2 double
// D) multiplying 2 int
// E) concate 2 string
// F) Concate 3 String

// Interface
interface PerformActions {
    // Below all are the abstract methods
    // Which need to be overridden by
    // some class
    fun addInteger(x: Int, y: Int)

    fun addDouble(x: Double, y: Double)

    fun multiplyInt(x: Int, y: Int)

    fun concatString(str1: String, str2: String)

    fun concatThreeStrings(str1: String, str2: String, str3: String)
}

class Q2: PerformActions {
    override fun addInteger(x: Int, y: Int) {
        println("Sum of Int = ${x+y}")
    }

    override fun addDouble(x: Double, y: Double) {
        println("Sum of Double = ${x+y}")
    }

    override fun multiplyInt(x: Int, y: Int) {
        println("Mutiplication of Int = ${x+y}")
    }

    override fun concatString(str1: String, str2: String) {
        println("Two concatenated strings = ${str1.plus(str2)}")
    }

    override fun concatThreeStrings(str1: String, str2: String, str3: String) {
        println("Three concatenated strings = ${str1.plus(str2).plus(str3)}")
    }


=======
// WAP to create singleton class.

object Q2 {
    // This is shorthand function in kotlin
    fun addThreeInt(a: Int, b: Int, c: Int) = a+b+c
>>>>>>> Stashed changes
}