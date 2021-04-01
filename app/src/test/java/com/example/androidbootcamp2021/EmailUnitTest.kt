package com.example.androidbootcamp2021

import org.junit.Assert
import org.junit.Test

class EmailUnitTest {
    @Test
    fun testEmailFormat_isCorrect() {
        val emailAddress = "shubham@gmail.com"
        val emailIsCorrect = signUpWithEmailOnly(emailAddress)
        Assert.assertTrue(emailIsCorrect)
    }
}