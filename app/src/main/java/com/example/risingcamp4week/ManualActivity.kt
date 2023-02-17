package com.example.risingcamp4week

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.risingcamp4week.databinding.ActivityManualBinding

class ManualActivity : AppCompatActivity() {

    private lateinit var mediaPlayer : MediaPlayer
    private lateinit var binding : ActivityManualBinding          //1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManualBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 음악 시작, 앱종료시까지 유지
        mediaPlayer = MediaPlayer.create(this, R.raw.florallife);
//        mediaPlayer.setLooping(true) //무한재생
        mediaPlayer.start();
        
        // 이미지 설명
        val iv_spor = binding.ivSporManual
        val iv_mush = binding.ivMushSample
        val iv_zomb = binding.ivZombSample
        val iv_ibul = binding.ivIbulSample
        val iv_kuzz = binding.ivKuzzSample
        val iv_cold = binding.ivColdSample
        val iv_juni = binding.ivJuniSample
        val iv_pepe = binding.ivPepeSample
        val iv_dark = binding.ivDarkSample
        Glide.with(this).load(R.drawable.spor_move).into(iv_spor)
        Glide.with(this).load(R.drawable.mush_move).into(iv_mush)
        Glide.with(this).load(R.drawable.zomb_move).into(iv_zomb)
        Glide.with(this).load(R.drawable.ibul_move).into(iv_ibul)
        Glide.with(this).load(R.drawable.kuzz_move).into(iv_kuzz)
        Glide.with(this).load(R.drawable.cold_move).into(iv_cold)
        Glide.with(this).load(R.drawable.juni_move).into(iv_juni)
        Glide.with(this).load(R.drawable.pepe_move).into(iv_pepe)
        Glide.with(this).load(R.drawable.dark_move).into(iv_dark)
        
        // 시작하기 버튼
        val start = binding.startBtnToMain
        start.setOnClickListener{
            mediaPlayer.pause()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}