package com.example.gaanabaja

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.SeekBar
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.gaanabaja.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //to use the seek bar when music is playing we need a runnable and a handler
    private lateinit var runnable: Runnable
    private var handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        //create instance of the media player
        val mediaPlayer = MediaPlayer.create(this,R.raw.music)
        //set the seek bar progress to 0 initially
        binding.musicSeekBar.progress = 0
        //define the max of seekbar
        binding.musicSeekBar.max = mediaPlayer.duration

        binding.playButton.setOnClickListener{
            if (!mediaPlayer.isPlaying){
                mediaPlayer.start()
                binding.playButton.setImageResource(R.drawable.ic_pause)
            }else{
                mediaPlayer.pause()
                binding.playButton.setImageResource(R.drawable.ic_play)
            }
        }

        //set the seekbar event now
        binding.musicSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, changed: Boolean) {
                //music will change according to the seekbar position
                if (changed){
                    mediaPlayer.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        //set the seekbar to play the music while changing it
        runnable = Runnable {
            binding.musicSeekBar.progress = mediaPlayer.currentPosition
            handler.postDelayed(runnable,1000)
        }
        handler.postDelayed(runnable,1000)
        //now we need to change the seek bar to 0 when music finish and also change the icon of the play button
        mediaPlayer.setOnCompletionListener {
            binding.playButton.setImageResource(R.drawable.ic_play)
            binding.musicSeekBar.progress = 0
        }

        binding.skipPreviousButton.setOnClickListener {
            Toast.makeText(this,"You can't skip this one",Toast.LENGTH_SHORT).show()
        }

        binding.skipNextButton.setOnClickListener {
            Toast.makeText(this,"You can't skip this one",Toast.LENGTH_SHORT).show()
        }
    }
}