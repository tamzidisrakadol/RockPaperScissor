package com.example.rockpaperscissor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import com.example.rockpaperscissor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var cScore = 0
    private var pScore = 0
    private var currentProgress = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.paperImg.setOnClickListener {
            binding.userImg.setImageDrawable(resources.getDrawable(R.drawable.paper))
            when((1..3).random()){
                1 -> {
                    binding.computerImg.setImageDrawable(resources.getDrawable(R.drawable.stone))
                    pScore++
                    binding.playerScoreTv.text = "Player score : $pScore"

                }
                2 -> {
                    binding.computerImg.setImageDrawable(resources.getDrawable(R.drawable.scissors))
                    cScore++
                    binding.computerScoreTV.text = "Computer Score : $cScore"
                }
                else -> {
                    binding.computerImg.setImageDrawable(resources.getDrawable(R.drawable.paper))
                    Toast.makeText(this, "TIE", Toast.LENGTH_SHORT).show()
                }

            }

        }

        binding.rockImg.setOnClickListener {
            binding.userImg.setImageDrawable(resources.getDrawable(R.drawable.stone))
            when((1..3).random()){
                1 -> {
                    binding.computerImg.setImageDrawable(resources.getDrawable(R.drawable.paper))
                    cScore++
                    binding.computerScoreTV.text = "Computer score : $cScore"

                }
                2 -> {
                    binding.computerImg.setImageDrawable(resources.getDrawable(R.drawable.scissors))
                    pScore++
                    binding.playerScoreTv.text = "Player Score : $pScore"
                }
                else -> {
                    binding.computerImg.setImageDrawable(resources.getDrawable(R.drawable.stone))
                    Toast.makeText(this, "TIE", Toast.LENGTH_SHORT).show()
                }

            }
        }

        binding.scissorImg.setOnClickListener {
            binding.userImg.setImageDrawable(resources.getDrawable(R.drawable.scissors))
            when((1..3).random()){
                1 -> {
                    binding.computerImg.setImageDrawable(resources.getDrawable(R.drawable.stone))
                    cScore++
                    binding.computerScoreTV.text = "Computer score : $cScore"

                }
                2 -> {
                    binding.computerImg.setImageDrawable(resources.getDrawable(R.drawable.paper))
                    pScore++
                    binding.playerScoreTv.text = "Player Score : $pScore"
                }
                else -> {
                    binding.computerImg.setImageDrawable(resources.getDrawable(R.drawable.scissors))
                    Toast.makeText(this, "TIE", Toast.LENGTH_SHORT).show()
                }

            }
        }

        object : CountDownTimer(16000,1000){
            override fun onTick(p0: Long) {
                binding.counterTV.text = "${p0/1000}"
                currentProgress+=7
                binding.progressBar2.progress = currentProgress
                binding.progressBar2.max = 100
            }

            override fun onFinish() {
                Toast.makeText(this@MainActivity, "Time up", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MainActivity,ResultActivity::class.java)
                intent.putExtra("playerScore",pScore)
                intent.putExtra("computerScore",cScore)
                startActivity(intent)
                finish()
            }

        }.start()

    }
}