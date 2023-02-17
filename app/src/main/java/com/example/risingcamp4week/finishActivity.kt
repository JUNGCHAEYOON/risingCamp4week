package com.example.risingcamp4week

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.risingcamp4week.databinding.ActivityFinishBinding

class finishActivity : AppCompatActivity() {

    private lateinit var binding : ActivityFinishBinding        // 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinishBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 넘겨받은 key 변수, true 이면 성공 false 이면 실패
        val key = intent.getIntExtra("key",0)
        if(key == 1){
            binding.tvFinish.text = "성공!"
        }else{
            binding.tvFinish.text = "실패ㅠㅠ"
        }


        // 재시작 버튼
        val restart_btn = binding.ivRestartBtn
        restart_btn.setOnClickListener{
            val intent = Intent(this, IntroActivity::class.java)
            startActivity(intent)
        }
    }

}