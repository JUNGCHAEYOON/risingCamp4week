package com.example.risingcamp4week

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.risingcamp4week.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var sporAnimation : AnimationDrawable      // 스포아 애니메이션
    private lateinit var mushAnimation : AnimationDrawable      // 주황버섯 애니메이션
    private lateinit var zombAnimation : AnimationDrawable      // 주황버섯 애니메이션
    private lateinit var warrAnimation : AnimationDrawable      // 전사 애니메이션
    private var point : Int = 0                                 // 획득 점수
    private lateinit var binding : ActivityMainBinding          //1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)   //2
        setContentView(binding.root)                            //3

        /* 변수 설정 */
        val warr0 = binding.ivWarr0     //전사
        val mob1 = binding.ivMob1       //스포아
        val mob2 = binding.ivMob2       //주황버섯
        val mob3 = binding.ivMob3       //좀비버섯
        val tvpoint = binding.tvPoint     //점수

        // 점수 초기화
        tvpoint.text = point.toString()

        /* 애니메이션 적용 */
        Glide.with(this).load(R.drawable.warr_move).into(warr0)
        Glide.with(this).load(R.drawable.spor_move).into(mob1)
        mob1.setTag("spor")
        Glide.with(this).load(R.drawable.spor_move).into(mob2)
        mob2.setTag("spor")
        Glide.with(this).load(R.drawable.spor_move).into(mob3)
        mob3.setTag("spor")
        
        // 이미지 리스트
        var mobArraylist = ArrayList<Int>()
        mobArraylist.add(R.drawable.spor_move)
        mobArraylist.add(R.drawable.mush_move)
        mobArraylist.add(R.drawable.zomb_move)

        /* 쓰레드 부분 */
        // 핸들러
        var handler = Handler(Looper.getMainLooper())

        // mob1 쓰레드
        Thread(){
            for(i in mobArraylist){
                handler.post{
                    Glide.with(this).load(i).into(mob1)
                    when(i){
                        R.drawable.spor_move -> mob1.setTag("spor")
                        R.drawable.mush_move -> mob1.setTag("mush")
                        else -> mob1.setTag("zomb")
                    }
                }
                Thread.sleep(4000)
            }
        }.start()

        //mob2 쓰레드
        Thread(){
            for(i in mobArraylist){
                handler.post{
                    Glide.with(this).load(i).into(mob2)
                    when(i){
                        R.drawable.spor_move -> mob2.setTag("spor")
                        R.drawable.mush_move -> mob2.setTag("mush")
                        else -> mob2.setTag("zomb")
                    }
                }
                Thread.sleep(3000)
            }
        }.start()

        //mob3 쓰레드
        Thread(){
            for(i in mobArraylist){
                handler.post{
                    Glide.with(this).load(i).into(mob3)
                    when(i){
                        R.drawable.spor_move -> mob3.setTag("spor")
                        R.drawable.mush_move -> mob3.setTag("mush")
                        else -> mob3.setTag("zomb")
                    }
                }
                Thread.sleep(2000)
            }
        }.start()

        /* 버튼 클릭 */
        // mob1 버튼 클릭
        mob1.setOnClickListener {
            if(mob1.getTag() == "mush"){
                Toast.makeText(this, "잡았다!", Toast.LENGTH_SHORT).show()
                point += 1
                tvpoint.text = point.toString()
            }else{
                Toast.makeText(this, "실패!", Toast.LENGTH_SHORT).show()
            }
            mob1.visibility = View.GONE
        }
        
        // mob2 버튼 클릭
        mob2.setOnClickListener {
            if(mob2.getTag() == "mush"){
                Toast.makeText(this, "잡았다!", Toast.LENGTH_SHORT).show()
                point += 1
                tvpoint.text = point.toString()
            }else{
                Toast.makeText(this, "실패!", Toast.LENGTH_SHORT).show()
            }
            mob2.visibility = View.GONE
        }
        
        // mob3 버튼 클릭
        mob3.setOnClickListener {
            if(mob3.getTag() == "mush"){
                Toast.makeText(this, "잡았다!", Toast.LENGTH_SHORT).show()
                point += 1
                tvpoint.text = point.toString()
            }else{
                Toast.makeText(this, "실패!", Toast.LENGTH_SHORT).show()
            }
            mob3.visibility = View.GONE
        }
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