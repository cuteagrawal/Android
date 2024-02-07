package com.st991629230.basketballdemobycuteagrawal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.st991629230.basketballdemobycuteagrawal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val scoreModel by lazy {
        ViewModelProvider(this).get(ScoreViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Score for Team A
        displayForTeamA(scoreModel.scoreTeamA)

        // Score for Team B
        displayForTeamB(scoreModel.scoreTeamB)


    }


    //functions for Team A
    fun addOneForTeamA(v: View?) {
        scoreModel.scoreTeamA =
            scoreModel.scoreTeamA + 1
        displayForTeamA(scoreModel.scoreTeamA)
    }

    fun addTwoForTeamA(v: View?) {
        addOneForTeamA(v)
        addOneForTeamA(v)
    }

    fun addThreeForTeamA(v: View?) {
        addOneForTeamA(v)
        addOneForTeamA(v)
        addOneForTeamA(v)
    }

    private fun displayForTeamA(score: Int) {
        binding.teamAScore.text = score.toString()
    }


    //functions for Team B
    fun addOneForTeamB(v: View?) {
        scoreModel.scoreTeamB =
            scoreModel.scoreTeamB + 1
        displayForTeamB(scoreModel.scoreTeamB)
    }

    fun addTwoForTeamB(v: View?) {
        addOneForTeamB(v)
        addOneForTeamB(v)
    }

    fun addThreeForTeamB(v: View?) {
        addOneForTeamB(v)
        addOneForTeamB(v)
        addOneForTeamB(v)
    }

    private fun displayForTeamB(score: Int) {
        binding.teamBScore.text = score.toString()
    }

    // Reset Score Method
    fun resetScore(v: View?){

        scoreModel.scoreTeamA = 0
        displayForTeamA(scoreModel.scoreTeamA)

        scoreModel.scoreTeamB = 0
        displayForTeamB(scoreModel.scoreTeamB)
    }
}