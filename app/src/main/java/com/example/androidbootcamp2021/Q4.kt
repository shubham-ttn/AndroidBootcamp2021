package com.example.androidbootcamp2021

// Create Kotlin classes having suitable attributes for Library management system.Use OOPs concepts
// in your design.Also try to use interfaces and abstract classes.

abstract class Library {
    var bookName: String = ""
    var bookID: Int = 0
    var bookAuthor: String = ""

    abstract fun addBook(bkName: String, bkID: Int, bkAutor: String)

    abstract fun getBookDetails()
}

class Q4: Library(){

    override fun addBook(bkName: String, bkID: Int, bkAutor: String) {
        bookName = bkName
        bookID = bkID
        bookAuthor = bkAutor
    }

    override fun getBookDetails() {
        println("Book id: $bookID")
        println("Book name: $bookName")
        println("Book author: $bookAuthor\n")
    }
}