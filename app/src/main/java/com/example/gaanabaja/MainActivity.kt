package com.example.gaanabaja

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.gaanabaja.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var paused = true /* this variable will tell that song is playing or it is paused*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.playButton.setOnClickListener{
            if (paused){
                Toast.makeText(this,"Playing...",Toast.LENGTH_SHORT).show()
                binding.playButton.setImageResource(R.drawable.ic_pause)
                paused = false
            }else{
                Toast.makeText(this,"Paused",Toast.LENGTH_SHORT).show()
                binding.playButton.setImageResource(R.drawable.ic_play)
                paused = true
            }
        }

        binding.skipPreviousButton.setOnClickListener {
            Toast.makeText(this,"You can't skip this one",Toast.LENGTH_SHORT).show()
        }

        binding.skipNextButton.setOnClickListener {
            Toast.makeText(this,"You can't skip this one",Toast.LENGTH_SHORT).show()
        }
    }
}