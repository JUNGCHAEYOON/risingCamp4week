package com.example.risingcamp4week

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.risingcamp4week.databinding.ActivityMainBinding
import com.example.risingcamp4week.databinding.ActivityManualBinding

class ManualActivity : AppCompatActivity() {

    private lateinit var binding : ActivityManualBinding          //1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManualBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        // 이미지 설명
        val iv_spor = binding.ivSporManual
        val iv_mush = binding.ivMushSample
        val iv_zomb = binding.ivZombSample
        Glide.with(this).load(R.drawable.spor_move).into(iv_spor)
        Glide.with(this).load(R.drawable.mush_move).into(iv_mush)
        Glide.with(this).load(R.drawable.zomb_move).into(iv_zomb)
        
        // 시작하기 주황버섯 버튼
        val start = binding.startBtnToMain
        start.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}