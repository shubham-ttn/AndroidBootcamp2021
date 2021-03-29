package com.example.androidbootcamp2021.model

import android.util.Log

class Board {
    private val cells = Array(3) { Array(3) { " " } }
    var winner: Player? = null
    lateinit var currentTurn: Player
    lateinit var gameState: GameState
    private val TAG = "Board"


    fun restart() {
        clearCells()
        winner = null
        currentTurn = Player.X
        gameState = GameState.IN_PROGRESS
    }


    /**
     *  To clear all cells
     */
    private fun clearCells() {
        for (i in 0..2) {
            for (j in 0..2) {
                cells[i][j] = ""
            }
        }
    }


    fun mark(row: Int, col: Int): Player? {
        var playerThatMoved: Player? = null
        if (isValid(row, col)) {
            cells[row][col] = currentTurn.toString()
            Log.i(TAG, "Current Player: $currentTurn ****")
            playerThatMoved = currentTurn

            if (isWinningMoveByPlayer(currentTurn, row, col)) {
                winner = currentTurn
//                Log.i(TAG, "Winner is $winner")
                gameState = GameState.FINISHED
            } else {
                flipTurn()
            }
        }

        return if (gameState == GameState.FINISHED) {
            Log.i(TAG, "Winner $winner")
            winner
        } else
            playerThatMoved
    }


    fun getGameWinner(): Player? {
        return winner
    }

    /**
     * function to flip the turn
     */

    private fun flipTurn() {
        currentTurn = if (currentTurn == Player.X) {
            Player.O
        } else {
            Player.X
        }
    }

    /**
     * return true is any of these condition matches
     * conditions that are required to win the game
     */
    private fun isWinningMoveByPlayer(Player: Player, currentRow: Int, currentCol: Int): Boolean {

        return ((
                // 3 -in-a row
                cells[currentRow][0] == Player.toString()
                        && cells[currentRow][1] == Player.toString()
                        && cells[currentRow][2] == Player.toString())

                // or 3-in-a column
                || (cells[0][currentCol] == Player.toString()
                && cells[1][currentCol] == Player.toString()
                && cells[2][currentCol] == Player.toString())

                // diagnol
                || (currentCol == currentRow
                && cells[0][0] == Player.toString()
                && cells[1][1] == Player.toString()
                && cells[2][2] == Player.toString())

                //opposite diagnal
                || (currentCol + currentRow == 2
                && cells[0][2] == Player.toString()
                && cells[1][1] == Player.toString()
                && cells[2][0] == Player.toString())

                )
    }

    /**
     * check if the cell selected is valid or not
     * @return boolean
     */
    private fun isValid(row: Int, col: Int): Boolean {
        return if (gameState == GameState.FINISHED) {
            false
        } else
            if (isOutOfBound(row) || isOutOfBound(col)) {
                false
            } else !isCellValueAlreadySet(row, col)
    }


    /**
     * check that whether the  cell is already set
     */
    private fun isCellValueAlreadySet(row: Int, col: Int): Boolean {
        return !(cells[row][col].isEmpty())
    }


    /**
     * check that given row or col is in range
     * @return boolean value
     */
    private fun isOutOfBound(row: Int): Boolean {
        return (row < 0 || row > 2)
    }

}