package com.st991629230.basketballdemobycuteagrawal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.st991629230.basketballdemobycuteagrawal.databinding.ActivityMainBinding

class BasketBallDemoByCuteAgrawal : AppCompatActivity() {

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
        displayForTeamA(scoreModel.getScoreForTeamA())

        // Score for Team B
        displayForTeamB(scoreModel.getScoreForTeamB())


    }


    //functions for Team A
    fun addOneForTeamA(v: View?) {
        scoreModel.setScoreForTeamA(scoreModel.getScoreForTeamA() + 1)
        displayForTeamA(scoreModel.getScoreForTeamA())

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
        scoreModel.setScoreForTeamB(scoreModel.getScoreForTeamB() + 1)
        displayForTeamB(scoreModel.getScoreForTeamB())
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

        scoreModel.setScoreForTeamA(0)
        displayForTeamA(scoreModel.getScoreForTeamA())

        scoreModel.setScoreForTeamB(0)
        displayForTeamB(scoreModel.getScoreForTeamB())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.basketballmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}