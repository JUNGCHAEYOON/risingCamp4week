package com.example.risingcamp4week

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.risingcamp4week.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList 

class MainActivity : AppCompatActivity() {

    private var point : Int = 0                                 // 획득 점수
    private var mobCount : Int = 9                              // 몹수, 0되면 종료
    private lateinit var binding : ActivityMainBinding          //1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)   //2
        setContentView(binding.root)                            //3

        /* 변수 설정 */
        val warr0 = binding.ivWarr0     //전사
        //몹
        val mob1 = binding.ivMob1
        val mob2 = binding.ivMob2
        val mob3 = binding.ivMob3
        val mob4 = binding.ivMob4
        val mob5 = binding.ivMob5
        val mob6 = binding.ivMob6
        val mob7 = binding.ivMob7
        val mob8 = binding.ivMob8
        val mob9 = binding.ivMob9
        val tvpoint = binding.tvPoint     //점수

        // 점수 초기화
        tvpoint.text = point.toString()

        /* 애니메이션 적용 */
        Glide.with(this).load(R.drawable.warr_move).into(warr0)
        
        // 몹 초기화
        mobReset(mob1)
        mobReset(mob2)
        mobReset(mob3)
        mobReset(mob4)
        mobReset(mob5)
        mobReset(mob6)
        mobReset(mob7)
        mobReset(mob8)
        mobReset(mob9)

        // mob 쓰레드
        mobEvent(mob1)
        mobEvent(mob2)
        mobEvent(mob3)
        mobEvent(mob4)
        mobEvent(mob5)
        mobEvent(mob6)
        mobEvent(mob7)
        mobEvent(mob8)
        mobEvent(mob9)

        // mob 버튼 클릭
        mobClickEvent(mob1)
        mobClickEvent(mob2)
        mobClickEvent(mob3)
        mobClickEvent(mob4)
        mobClickEvent(mob5)
        mobClickEvent(mob6)
        mobClickEvent(mob7)
        mobClickEvent(mob8)
        mobClickEvent(mob9)
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
    fun mobReset(mob : ImageView){
        Glide.with(this).load(R.drawable.spor_move).into(mob)
        mob.setTag("spor")
    }

    fun mobEvent(mob : ImageView){
        // 이미지 리스트
        var mobArraylist = ArrayList<Int>()
        mobArraylist.add(R.drawable.spor_move)
        mobArraylist.add(R.drawable.mush_move)
        mobArraylist.add(R.drawable.zomb_move)

        // 핸들러
        var handler = Handler(Looper.getMainLooper())
        val random = Random()
        val randomCount = random.nextInt(5000)

        Thread(){
            Thread.sleep(randomCount.toLong())
            for(i in mobArraylist){
                handler.post{
                    Glide.with(this).load(i).into(mob)
                    when(i){
                        R.drawable.spor_move -> mob.setTag("spor")
                        R.drawable.mush_move -> mob.setTag("mush")
                        else -> mob.setTag("zomb")
                    }
                }
                Thread.sleep(2000)
            }
        }.start()
    }

    fun mobClickEvent(mob : ImageView){
        // mob1 버튼 클릭
        mob.setOnClickListener {
            if(mob.getTag() == "mush"){
                point += 1
                binding.tvPoint.text = point.toString()
                mobCount -= 1
                Toast.makeText(this, "잡았다!", Toast.LENGTH_SHORT).show()
                if(mobCount == 0){
                    val intent = Intent(this, ManualActivity::class.java)
                    startActivity(intent)
                }
            }else{
                mobCount -= 1
                Toast.makeText(this, "실패!", Toast.LENGTH_SHORT).show()
                if(mobCount == 0){
                    val intent = Intent(this, ManualActivity::class.java)
                    startActivity(intent)
                }
            }
            mob.visibility = View.GONE
        }
    }


}