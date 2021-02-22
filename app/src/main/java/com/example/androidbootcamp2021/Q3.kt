package com.example.androidbootcamp2021

// WAP to create sealed Base class and 3 subclasses of Base class, write a function which will have
// base class object as an argument and it will return name of the subclass based argument type.

sealed class Q3 {
    val msg = "Hello World!"


    fun getClass(base: Q3) {
        println("This is ${base.javaClass}")
    }
}

class A: Q3(){
}

class B: Q3(){
}

class C: Q3(){
}