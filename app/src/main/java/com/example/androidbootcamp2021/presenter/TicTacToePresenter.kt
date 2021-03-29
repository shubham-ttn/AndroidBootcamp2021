package com.example.androidbootcamp2021.presenter

import android.util.Log
import com.example.androidbootcamp2021.model.Board
import com.example.androidbootcamp2021.view.TicTacToeView

class TicTacToePresenter():Presenter {

    lateinit var view: TicTacToeView
    constructor(view: TicTacToeView):this(){
        this.view = view
    }
    var model: Board = Board()


    override fun onCreate() {
        model.restart()
        resetUI()
        Log.i("TicTac", "Game has been reset")
    }

    private fun resetUI() {
        for (i in 0..2) {
            for (j in 0..2) {
                view.setButtonText(i, j, "")
            }
        }
    }

    //mark the area
    fun onButtonSelected(row: Int, col: Int) {
        val playerThatMoved = model.mark(row, col)

        if (playerThatMoved !=null){
            view.setButtonText(row, col, playerThatMoved.toString())

            if (model.getGameWinner() != null) {
                view.showWinner("Winner is $playerThatMoved")
            }
        }
        else
            view.showWinner("It's a Draw match")
    }
}