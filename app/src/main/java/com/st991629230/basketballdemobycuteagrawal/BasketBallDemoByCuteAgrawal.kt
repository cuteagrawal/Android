package com.st991629230.basketballdemobycuteagrawal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.st991629230.basketballdemobycuteagrawal.databinding.ActivityMainBinding

class BasketBallDemoByCuteAgrawal : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val scoreModel by lazy {
        ViewModelProvider(this).get(ScoreViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
    fun resetScore(v: View?) {

        scoreModel.setScoreForTeamA(0)
        displayForTeamA(scoreModel.getScoreForTeamA())

        scoreModel.setScoreForTeamB(0)
        displayForTeamB(scoreModel.getScoreForTeamB())
    }

    fun resetScores() {

        scoreModel.setScoreForTeamA(0)
        displayForTeamA(scoreModel.getScoreForTeamA())

        scoreModel.setScoreForTeamB(0)
        displayForTeamB(scoreModel.getScoreForTeamB())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.basketballmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.new_game -> {


                val builder: AlertDialog.Builder = AlertDialog.Builder(this)
                builder
                    .setMessage("Are you sure you want to start a New Game?")
                    .setTitle("Start a New Game?")
                    .setPositiveButton("Yes") { dialog, which ->
                        resetScores()
                    }
                    .setNegativeButton("No") { dialog, which ->

                    }
                val dialog: AlertDialog = builder.create()
                dialog.show()

                return true
            }
            R.id.exit -> {

                val builder: AlertDialog.Builder = AlertDialog.Builder(this)
                builder
                    .setMessage("Are you sure you want to Exit the Game?")
                    .setTitle("Exit Game?")
                    .setPositiveButton("Exit") { dialog, which ->
                        finish()
                    }
                    .setNegativeButton("Go Back") { dialog, which ->

                    }
                val dialog: AlertDialog = builder.create()
                dialog.show()

                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}

