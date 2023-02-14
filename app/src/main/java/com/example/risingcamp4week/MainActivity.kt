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
                binding.mob1.setText("스포아")
                Thread.sleep(1000)
                binding.mob1.setText("주황버섯")
                Thread.sleep(1000)
                binding.mob1.setText("좀비버섯")
                Thread.sleep(1000)
            }
        }.start()

        Thread(){
            while(true){
                binding.mob2.setText("스포아")
                Thread.sleep(1000)
                binding.mob2.setText("주황버섯")
                Thread.sleep(1000)
                binding.mob2.setText("좀비버섯")
                Thread.sleep(1000)
            }
        }.start()

        Thread(){
            while(true){
                binding.mob3.setText("스포아")
                Thread.sleep(1000)
                binding.mob3.setText("주황버섯")
                Thread.sleep(1000)
                binding.mob3.setText("좀비버섯")
                Thread.sleep(1000)
            }
        }.start()

        Thread(){
            while(true){
                binding.mob4.setText("스포아")
                Thread.sleep(1000)
                binding.mob4.setText("주황버섯")
                Thread.sleep(1000)
                binding.mob4.setText("좀비버섯")
                Thread.sleep(1000)
            }
        }.start()

        Thread(){
            while(true){
                binding.mob5.setText("스포아")
                Thread.sleep(1000)
                binding.mob5.setText("주황버섯")
                Thread.sleep(1000)
                binding.mob5.setText("좀비버섯")
                Thread.sleep(1000)
            }
        }.start()

        Thread(){
            while(true){
                binding.mob6.setText("스포아")
                Thread.sleep(1000)
                binding.mob6.setText("주황버섯")
                Thread.sleep(1000)
                binding.mob6.setText("좀비버섯")
                Thread.sleep(1000)
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