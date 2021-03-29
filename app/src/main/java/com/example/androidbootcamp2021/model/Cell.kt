package com.example.androidbootcamp2021.model

class Cell {
    private var value:Player?=null

    fun getPlayerValue():Player{return value!!}
    fun setPlayerValue(value: Player){this.value=value}
}