package com.example.androidbootcamp2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.androidbootcamp2021.presenter.TicTacToePresenter
import com.example.androidbootcamp2021.view.TicTacToeView
import kotlinx.android.synthetic.main.activity_tic_tac_toe.*

class TicTacToeActivity : AppCompatActivity(), TicTacToeView, View.OnClickListener {


    lateinit var winnerPlayerLabel: TextView
    lateinit var winnerPlayerViewGroup: View
    lateinit var buttonGrid: ViewGroup
    var buttons = arrayOfNulls<Button>(9)
    private val presenter = TicTacToePresenter(this)
    private val TAG = TicTacToeActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tic_tac_toe)

        winnerPlayerLabel = findViewById(R.id.winnerPlayerLabel)
        winnerPlayerViewGroup = findViewById(R.id.winnerPlayerViewGroup)
        buttonGrid = findViewById(R.id.buttonGrid)

        //create the view
        presenter.onCreate()

        for (i in buttons.indices) {
            val buttonID = "btn_$i"
            val resourceId = resources.getIdentifier(buttonID, "id", packageName)
            buttons[i] = findViewById(resourceId)
            buttons[i]!!.setOnClickListener(this)
        }

        resetGame_BTN.setOnClickListener {
            resetGame()
        }
    }

    /**
     * It will restart the game
     */
    private fun resetGame() {
        Log.i(TAG, "Game reset")
        presenter.onCreate()
    }

    override fun setButtonText(row: Int, col: Int, text: String) {
        buttonGrid.findViewWithTag<Button>("" + row + col)?.text = text
    }

    override fun onClick(v: View?) {
        val buttonId = v!! as Button
        val tag = buttonId.tag.toString()

        //splitting tag into row and col
        val row = tag.substring(0, 1).toInt()
        val col = tag.substring(1, 2).toInt()

        //send row and col to presenter
        presenter.onButtonSelected(row, col)
    }

    override fun showWinner(winningPlayer: String) {
        winnerPlayerLabel.text = winningPlayer
        winnerPlayerViewGroup.visibility = View.VISIBLE
    }
}