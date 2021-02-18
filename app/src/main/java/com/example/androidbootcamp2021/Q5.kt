package com.example.androidbootcamp2021

//Write a function which take marks as an argument and return the the grade as follows:
//marks between 50 to 60 , return “Good”
//marks between 60 to 70, return “Very Good”
//marks between 70 to  80, return “Excellent”
//marks between  80 to 100, return “Rockstar”

class Q5 {
    fun getGradeDetails(marks: Int): String {
        println("Your marks is $marks")
        return when(marks) {
            in 80..100 -> "Rockstar"
            in 70..80 -> "Excellent"
            in 60..70 -> "Very Good"
            in 50..60 -> "Good"
            else -> "Invalid input"
        }
    }
}