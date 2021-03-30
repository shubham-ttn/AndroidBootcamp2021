package com.example.androidbootcamp2021.mvvm.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.databinding.ObservableArrayMap
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidbootcamp2021.mvvm.activity.TicTacToeMVVMActivity
import com.example.androidbootcamp2021.mvvm.model.Board
import com.example.androidbootcamp2021.mvvm.model.Player
import com.example.androidbootcamp2021.mvvm.utility.StringUtility.stringFromNumbers

class TicTacToeViewModel : ViewModel() {
    var board = Board()
    var cells: ObservableArrayMap<String, String>
    val TAG = TicTacToeViewModel::class.java.simpleName

    init {
        board.restart()
        cells = ObservableArrayMap()
    }

    fun onClickedCellAt(row: Int, col: Int) {
        val playerThatMoved = board.mark(row, col)

        if (playerThatMoved != null) {
            cells[stringFromNumbers(row, col)] = playerThatMoved.toString()

            if (board.getGameWinner() != null) {
                TicTacToeMVVMActivity().onGameWinnerChanged(board.getGameWinner())
                //Log.i(TAG, "Winner is ${board.getGameWinner()}")
            }
        }
        else
            Log.i(TAG, "It's a tie")
    }

    fun getWinner(): MutableLiveData<Player> {
        return board.winner
    }
}