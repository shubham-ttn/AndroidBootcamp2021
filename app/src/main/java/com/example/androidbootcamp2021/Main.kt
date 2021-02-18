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

    // Q2 Write a single program for following operation using overloading
    // A) Adding 2 integer number
    // B) Adding 2 double
    // D) multiplying 2 int
    // E) concate 2 string
    // F) Concate 3 String
    println("\nQ2")
    val ob2 = Q2()
    ob2.addInteger(3, 5)
    ob2.addDouble(10.5, 4.5)
    ob2.multiplyInt(4, 4)
    ob2.concatString("Hello ", "World")
    ob2.concatThreeStrings("This ", "is ", "Kotlin ")

    // Q3 Create 3 sub class of bank SBI,BOI,ICICI all 4 should have method called getDetails which provide
    // there specific details like rateofinterest etc,print details of every bank.
    println("\nQ3")
    val ob3 = SBI()
    ob3.getBankDetails()
    val ob4 = BOI()
    ob4.getBankDetails()
    val ob5 = ICICI()
    ob5.getBankDetails()

}