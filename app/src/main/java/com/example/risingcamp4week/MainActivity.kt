package com.example.risingcamp4week

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.risingcamp4week.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var sporAnimation : AnimationDrawable      // 스포아 애니메이션
    private lateinit var mushAnimation : AnimationDrawable      // 주황버섯 애니메이션
    private lateinit var zombAnimation : AnimationDrawable      // 주황버섯 애니메이션
    private lateinit var warrAnimation : AnimationDrawable      // 전사 애니메이션
    private lateinit var binding : ActivityMainBinding          //1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)   //2
        setContentView(binding.root)                            //3

        /* 변수 설정 */
        val warr0 = binding.warr0   //전사
        val mob1 = binding.mob1     //스포아
        val mob2 = binding.mob2     //주황버섯
        val mob3 = binding.mob3     //좀비버섯

        /* 애니메이션 적용 */
        Glide.with(this).load(R.drawable.warr_move).into(warr0)
        Glide.with(this).load(R.drawable.spor_move).into(mob1)
        Glide.with(this).load(R.drawable.mush_move).into(mob2)
        Glide.with(this).load(R.drawable.zomb_move).into(mob3)

        var mobArraylist = ArrayList<Int>()
        mobArraylist.add(R.drawable.spor_move)
        mobArraylist.add(R.drawable.mush_move)
        mobArraylist.add(R.drawable.zomb_move)

        // 핸들러
        var handler = Handler(Looper.getMainLooper())

        // 쓰레드
        Thread(){
            for(i in mobArraylist){
                handler.post{
                    Glide.with(this).load(i).into(mob1)
                }
                Thread.sleep(2000)
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