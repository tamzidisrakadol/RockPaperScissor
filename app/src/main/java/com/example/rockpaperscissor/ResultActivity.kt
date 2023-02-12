package com.example.rockpaperscissor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rockpaperscissor.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val playerScore = intent.getIntExtra("playerScore",0)
        val computerScore = intent.getIntExtra("computerScore",0)

        if (playerScore>computerScore){
            binding.winnerTV.text = "Congratulation \n" +
                    "Player Wins"
        }else if(playerScore<computerScore){
            binding.winnerTV.text = "Computer Wins \n" +
                    "better luck next time"
        }else{
            binding.winnerTV.text ="Congratulation \n" +
                    "we both win"
        }
    }
}