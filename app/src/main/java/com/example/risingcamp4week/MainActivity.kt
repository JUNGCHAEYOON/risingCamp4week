package com.example.risingcamp4week

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.risingcamp4week.databinding.ActivityMainBinding
import java.security.AccessController.getContext
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer              // 음악실행
    private var point: Int = 0                                 // 획득 점수
    private var mobCount: Int = 9                              // 몹수, 0되면 종료
    private lateinit var binding: ActivityMainBinding          //1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)   //2
        setContentView(binding.root)                            //3

        // 음악 시작, 앱종료시까지 유지
        mediaPlayer = MediaPlayer.create(this, R.raw.niunsup);
//        mediaPlayer.setLooping(true) //무한재생
        mediaPlayer.start();

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

        // 1라운드 12초 카운트 다운
        val intent1 = Intent(this, finishActivity::class.java)
        val intent2 = Intent(this, round2Activity::class.java)
        val countDown = object : CountDownTimer(1000 * 12, 1000) {
            override fun onTick(p0: Long) {
                // countDownInterval 마다 호출 (여기선 1000ms)
                binding.tvCount.text = (p0 / 1000).toString()
            }

            override fun onFinish() {
                mediaPlayer.pause()
                if(point > 4){
                    startActivity(intent2)
                }else {
                    intent1.putExtra("key", 0)
                    startActivity(intent1)
                }
            }
        }.start()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    fun mobReset(mob: ImageView) {
        Glide.with(this).load(R.drawable.spor_move).into(mob)
        mob.setTag("spor")
    }

    fun mobEvent(mob: ImageView) {
        // 이미지 리스트
        var mobArraylist = ArrayList<Int>()
        mobArraylist.add(R.drawable.spor_move)
        mobArraylist.add(R.drawable.mush_move)
        mobArraylist.add(R.drawable.zomb_move)

        // 핸들러
        var handler = Handler(Looper.getMainLooper())
        val random = Random()
        val randomCount = random.nextInt(5000)

        Thread() {
            Thread.sleep(randomCount.toLong())
            for (i in mobArraylist) {
                handler.post {
                    Glide.with(this).load(i).into(mob)
                    when (i) {
                        R.drawable.spor_move -> mob.setTag("spor")
                        R.drawable.mush_move -> mob.setTag("mush")
                        else -> mob.setTag("zomb")
                    }
                }
                Thread.sleep(2000)
                if (i == R.drawable.zomb_move) {
                    handler.post {
                        Glide.with(this).load(R.drawable.zomb_die).into(mob)
                    }
                    Thread.sleep(660)
                    handler.post{
                        mob.visibility = View.INVISIBLE
                    }
                }
            }
        }.start()
    }

    fun mobClickEvent(mob: ImageView) {
        // 핸들러
        var handler = Handler(Looper.getMainLooper())

        // mob1 버튼 클릭
        mob.setOnClickListener {
            if (mob.getTag() == "mush") {
                point += 1
                binding.tvPoint.text = point.toString()
                mobCount -= 1
                Glide.with(this).load(R.drawable.mush_die).into(mob)
                handler.postDelayed({
                    mob.visibility = View.INVISIBLE
                }, 660)
//                if (mobCount == 0) {
//                    if (point > 4) {
//                        mediaPlayer.pause()
//                        val intent = Intent(this, round2Activity::class.java)
//                        startActivity(intent)
//                    } else {
//                        mediaPlayer.pause()
//                        val intent = Intent(this, finishActivity::class.java)
//                        intent.putExtra("key", 0)
//                        startActivity(intent)
//                    }
//                }
            } else if (mob.getTag() == "spor") {
                mobCount -= 1
                Glide.with(this).load(R.drawable.spor_die).into(mob)
                handler.postDelayed({
                    mob.visibility = View.INVISIBLE
                }, 660)
//                if (mobCount == 0) {
//                    if (point > 4) {
//                        mediaPlayer.pause()
//                        val intent = Intent(this, round2Activity::class.java)
//                        startActivity(intent)
//                    } else {
//                        mediaPlayer.pause()
//                        val intent = Intent(this, finishActivity::class.java)
//                        intent.putExtra("key", 0)
//                        startActivity(intent)
//                    }
//                }
            } else {
                mobCount -= 1
                Glide.with(this).load(R.drawable.zomb_die).into(mob)
                handler.postDelayed({
                    mob.visibility = View.INVISIBLE
                }, 660)
//                if (mobCount == 0) {
//                    if (point > 4) {
//                        mediaPlayer.pause()
//                        val intent = Intent(this, round2Activity::class.java)
//                        startActivity(intent)
//                    } else {
//                        mediaPlayer.pause()
//                        val intent = Intent(this, finishActivity::class.java)
//                        intent.putExtra("key", 0)
//                        startActivity(intent)
//                    }
//                }
            }
        }
    }


}