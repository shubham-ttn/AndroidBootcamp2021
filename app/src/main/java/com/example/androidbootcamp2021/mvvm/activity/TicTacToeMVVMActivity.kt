package com.example.androidbootcamp2021.mvvm.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.androidbootcamp2021.R
import com.example.androidbootcamp2021.databinding.ActivityTicTacToeMvvmBinding
import com.example.androidbootcamp2021.mvvm.model.Player
import com.example.androidbootcamp2021.mvvm.viewmodel.TicTacToeViewModel
import kotlinx.android.synthetic.main.activity_tic_tac_toe_mvvm.*

class TicTacToeMVVMActivity : AppCompatActivity(), View.OnClickListener {

    var buttons = arrayOfNulls<Button>(9)
    lateinit var gameViewModel: TicTacToeViewModel
    var binding: ActivityTicTacToeMvvmBinding? = null
    private val TAG = TicTacToeMVVMActivity::class.java.simpleName
    var winner = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_tic_tac_toe_mvvm)
        binding?.gameViewModel = ViewModelProviders.of(this).get(TicTacToeViewModel::class.java)

        setupListeners()

    }

    private fun setupListeners() {
        for (i in buttons.indices) {
            val buttonnID = "btn_$i"
            val resourceId = resources.getIdentifier(buttonnID, "id", packageName)
            buttons[i] = findViewById(resourceId)
            buttons[i]!!.setOnClickListener(this)
        }
    }

    fun onGameWinnerChanged(winner: Player?) {
        if (winner == null) {
            Log.i(TAG, "No Winner $winner")
            binding?.winnerPlayerLabelTV?.text = "It's a tie"
        } else {
            Log.i(TAG, "Winner $winner")
            binding?.winnerPlayerLabelTV?.text = "$winner"
        }
    }

    override fun onClick(v: View?) {
        gameViewModel.getWinner()
            .observe(this, Observer { winner: Player? -> this.onGameWinnerChanged(winner!!) })
    }
}