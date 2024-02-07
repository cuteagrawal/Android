package com.st991629230.basketballdemobycuteagrawal

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

const val CURRENT_SCORE_A = "CURRENT_SCORE_A"
const val CURRENT_SCORE_B = "CURRENT_SCORE_B"

class ScoreViewModel(private val savedStateHandle: SavedStateHandle): ViewModel() {


    /*
    var scoreTeamA = 0
    var scoreTeamB = 0
     */


    private var scoreTeamA : Int
        get() = savedStateHandle.get(CURRENT_SCORE_A) ?: 0
        set(value) = savedStateHandle.set(CURRENT_SCORE_A, value)

    private var scoreTeamB : Int
        get() = savedStateHandle.get(CURRENT_SCORE_B) ?: 0
        set(value) = savedStateHandle.set(CURRENT_SCORE_B, value)




    fun getScoreForTeamA(): Int {
        return scoreTeamA
    }

    fun setScoreForTeamA(score: Int) {
        scoreTeamA = score
    }

    fun getScoreForTeamB(): Int {
        return scoreTeamB
    }

    fun setScoreForTeamB(score: Int) {
        scoreTeamB = score
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("MyModel", "OnCleared")
    }
}