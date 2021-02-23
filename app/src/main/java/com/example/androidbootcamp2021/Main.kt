package com.example.androidbootcamp2021

fun main() {

    // Q1 WAP using Lambda function to calculate the Simple Interest.
    println("Q1")
    val ob1 = Q1()
    val principalAmt = 2500
    val timeInYear = 2
    val rateOfInterest = 10
    // calling lambda function
    ob1.simpleInterest(principalAmt, timeInYear, rateOfInterest)

    // Q2 Create a list of Employee which will have name and age as properties. print the name of all employees age >30.
    println("\nQ2")
    println("Employees age greater than 30 are: ")
    val ob2 = Q2()
    ob2.createFilteredList()


}