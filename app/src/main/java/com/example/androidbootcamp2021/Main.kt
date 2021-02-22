package com.example.androidbootcamp2021

import java.lang.Error

fun main() {
    // Q1 WAP to produce NoClassDefFoundError and ClassNotFoundException exception.
    println("Q1")
    val ob1 = Q1()
    ob1.printMsg()
    /*
    try {
        val ob2 = AnyClass()
        ob2.printMsg()
    }
    catch (e: Error) {
        println(e)
    }

     */

    // Q2 WAP to create singleton class.
    println("\nQ2")
    println("The sum of three values are: ${Q2.addThreeInt(2, 3, 5)}")

    // Q3 WAP to create sealed Base class and 3 subclasses of Base class, write a function which will have
    // base class object as an argument and it will return name of the subclass based argument type.
    println("\nQ3")
    val ob3 = A()
    val ob4 = B()
    val ob5 = C()
    ob3.getClass(ob3)
    ob3.getClass(ob4)
    ob3.getClass(ob5)
}