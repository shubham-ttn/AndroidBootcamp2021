package com.example.androidbootcamp2021

// Q2 Write a program to find the number of occurrences of the duplicate words in a string and print them.

fun printOccurences() {
    val str = "hello world world welcome hello"
    val words = str.split(" ")

    var i = 0
    while (i < words.size-1) {
        var j = i+1
        var duplicateWord: String? = null
        var duplicateWordCount = 1
        while (j < words.size) {
            if (words[i] == words[j]) {
                duplicateWord = words[i]
                duplicateWordCount++
            }
            j++
        }
        if (duplicateWord != null) {
            println("Duplicate word: $duplicateWord, Occurences: $duplicateWordCount")
        }
        i++
    }
}