package com.example.androidbootcamp2021

import org.junit.Assert
import org.junit.Test

class EmailUnitTest {
    @Test
    fun testEmailShouldNotContainSpaces_isCorrect() {
        val emailAddress = "shubh am@gmail.com"
        val emailIsCorrect = signUpWithEmailOnly(emailAddress)
        Assert.assertTrue(emailIsCorrect)
    }

    @Test
    fun testEmailShouldContainCorrectDomain_isCorrect() {
        val emailAddress = "shubham@gmail.com"
        val emailIsCorrect = signUpWithEmailOnly(emailAddress)
        Assert.assertTrue(emailIsCorrect)
    }

    @Test
    fun testEmailShouldNotBeBlank_isCorrect() {
        val emailAddress = ""
        val emailIsCorrect = signUpWithEmailOnly(emailAddress)
        Assert.assertTrue(emailIsCorrect)
    }

    @Test
    fun testEmailFormat_isCorrect() {
        val emailAddress = "shubham@gmail.com"
        val emailIsCorrect = signUpWithEmailOnly(emailAddress)
        Assert.assertTrue(emailIsCorrect)
    }

    @Test
    fun testEmailShouldNotStartWithUnderScore_isCorrect() {
        val emailAddress = "helloshubham@gmail.com"
        val emailIsCorrect = signUpWithEmailOnly(emailAddress)
        Assert.assertTrue(emailIsCorrect)
    }
}