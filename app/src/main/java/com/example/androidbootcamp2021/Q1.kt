package com.example.androidbootcamp2021

//WAP using Lambda function to calculate the Simple Interest.

class Q1 {
    val simpleInterest = {principal: Int, time: Int, rate: Int ->
        println("Simple interest for Rs. $principal, Duration: $time years and Interest rate: $rate is: Rs. " + (principal*rate*time)/100)
    }
}