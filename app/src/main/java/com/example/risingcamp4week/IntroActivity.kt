package com.example.risingcamp4week

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import com.bumptech.glide.Glide

class IntroActivity : AppCompatActivity() {

    private lateinit var mediaPlayer : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        // 음악 시작, 앱종료시까지 유지
        mediaPlayer = MediaPlayer.create(this, R.raw.florallife);
        mediaPlayer.setLooping(true); //무한재생
        mediaPlayer.start();

        // 시작 버튼
        val startButton = findViewById<ImageView>(R.id.iv_start_btn)
        Glide.with(this).load(R.drawable.mush_move).into(startButton)
        startButton.setOnClickListener {
            val intent = Intent(this, ManualActivity::class.java)
            startActivity(intent)
        }

    }
}