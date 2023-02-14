package com.example.risingcamp4week

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import com.example.risingcamp4week.databinding.ActivityMainBinding
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding          //1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)   //2
        setContentView(binding.root)                            //3


        /* 쓰레드 구분 */
        // 핸들러
        var handler = Handler(Looper.getMainLooper())

        Thread(){
            while(true){

//                binding.mob1.setImageResource(R.drawable.spor)
//                Thread.sleep(1000)
                binding.mob1.setImageResource(R.drawable.mushroom)
                Thread.sleep(1000)
//                binding.mob1.setImageResource(R.drawable.zombiemushroom)
//                Thread.sleep(1000)

            }
        }.start()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }




}