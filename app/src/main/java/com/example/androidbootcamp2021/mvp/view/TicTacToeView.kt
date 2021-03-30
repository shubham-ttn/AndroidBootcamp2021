package com.example.androidbootcamp2021.mvp.view

interface TicTacToeView {
    fun setButtonText(row:Int, col:Int, text:String)
    fun showWinner(winningPlayer: String)
}