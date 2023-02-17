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
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.risingcamp4week.databinding.ActivityMainBinding
import com.example.risingcamp4week.databinding.ActivityRound2Binding
import java.util.*
import kotlin.collections.ArrayList

class round2Activity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer              // 음악실행
    private var point: Int = 0                                 // 획득 점수
    private var mobCount: Int = 25                             // 몹수, 0되면 종료
    private lateinit var binding: ActivityRound2Binding        // 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRound2Binding.inflate(layoutInflater)  //2
        setContentView(binding.root)                             //3

        // 음악 시작, 앱종료시까지 유지
        mediaPlayer = MediaPlayer.create(this, R.raw.whenthemorningcomes);
//        mediaPlayer.setLooping(true) //무한재생
        mediaPlayer.start()

        /* 변수 설정 */
        val warr2 = binding.ivWarr2     //전사
        //몹
        val iv_mob1_round2 = binding.ivMob1Round2
        val iv_mob2_round2 = binding.ivMob2Round2
        val iv_mob3_round2 = binding.ivMob3Round2
        val iv_mob4_round2 = binding.ivMob4Round2
        val iv_mob5_round2 = binding.ivMob5Round2
        val iv_mob6_round2 = binding.ivMob6Round2
        val iv_mob7_round2 = binding.ivMob7Round2
        val iv_mob8_round2 = binding.ivMob8Round2
        val iv_mob9_round2 = binding.ivMob9Round2
        val iv_mob10_round2 = binding.ivMob10Round2

        val iv_mob11_round2 = binding.ivMob11Round2
        val iv_mob12_round2 = binding.ivMob12Round2
        val iv_mob13_round2 = binding.ivMob13Round2
        val iv_mob14_round2 = binding.ivMob14Round2
        val iv_mob15_round2 = binding.ivMob15Round2
        val iv_mob16_round2 = binding.ivMob16Round2
        val iv_mob17_round2 = binding.ivMob17Round2
        val iv_mob18_round2 = binding.ivMob18Round2
        val iv_mob19_round2 = binding.ivMob19Round2
        val iv_mob20_round2 = binding.ivMob20Round2

        val iv_mob21_round2 = binding.ivMob21Round2
        val iv_mob22_round2 = binding.ivMob22Round2
        val iv_mob23_round2 = binding.ivMob23Round2
        val iv_mob24_round2 = binding.ivMob24Round2
        val iv_mob25_round2 = binding.ivMob25Round2


        //점수
        val tvpointround2 = binding.tvPointRound2

        /* 애니메이션 적용 */
        Glide.with(this).load(R.drawable.warr2_move).into(warr2)

        // 몹 초기화
        mobReset(iv_mob1_round2)
        mobReset(iv_mob2_round2)
        mobReset(iv_mob3_round2)
        mobReset(iv_mob4_round2)
        mobReset(iv_mob5_round2)

        mobReset(iv_mob6_round2)
        mobReset(iv_mob7_round2)
        mobReset(iv_mob8_round2)
        mobReset(iv_mob9_round2)
        mobReset(iv_mob10_round2)

        mobReset(iv_mob11_round2)
        mobReset(iv_mob12_round2)
        mobReset(iv_mob13_round2)
        mobReset(iv_mob14_round2)
        mobReset(iv_mob15_round2)

        mobReset(iv_mob16_round2)
        mobReset(iv_mob17_round2)
        mobReset(iv_mob18_round2)
        mobReset(iv_mob19_round2)
        mobReset(iv_mob20_round2)

        mobReset(iv_mob21_round2)
        mobReset(iv_mob22_round2)
        mobReset(iv_mob23_round2)
        mobReset(iv_mob24_round2)
        mobReset(iv_mob25_round2)


        // mob 쓰레드
        mobEvent(iv_mob1_round2)
        mobEvent(iv_mob2_round2)
        mobEvent(iv_mob3_round2)
        mobEvent(iv_mob4_round2)
        mobEvent(iv_mob5_round2)

        mobEvent(iv_mob6_round2)
        mobEvent(iv_mob7_round2)
        mobEvent(iv_mob8_round2)
        mobEvent(iv_mob9_round2)
        mobEvent(iv_mob10_round2)

        mobEvent(iv_mob11_round2)
        mobEvent(iv_mob12_round2)
        mobEvent(iv_mob13_round2)
        mobEvent(iv_mob14_round2)
        mobEvent(iv_mob15_round2)

        mobEvent(iv_mob16_round2)
        mobEvent(iv_mob17_round2)
        mobEvent(iv_mob18_round2)
        mobEvent(iv_mob19_round2)
        mobEvent(iv_mob20_round2)

        mobEvent(iv_mob21_round2)
        mobEvent(iv_mob22_round2)
        mobEvent(iv_mob23_round2)
        mobEvent(iv_mob24_round2)
        mobEvent(iv_mob25_round2)

        // mob 버튼 클릭
        mobClickEvent(iv_mob1_round2)
        mobClickEvent(iv_mob2_round2)
        mobClickEvent(iv_mob3_round2)
        mobClickEvent(iv_mob4_round2)
        mobClickEvent(iv_mob5_round2)

        mobClickEvent(iv_mob6_round2)
        mobClickEvent(iv_mob7_round2)
        mobClickEvent(iv_mob8_round2)
        mobClickEvent(iv_mob9_round2)
        mobClickEvent(iv_mob10_round2)

        mobClickEvent(iv_mob11_round2)
        mobClickEvent(iv_mob12_round2)
        mobClickEvent(iv_mob13_round2)
        mobClickEvent(iv_mob14_round2)
        mobClickEvent(iv_mob15_round2)

        mobClickEvent(iv_mob16_round2)
        mobClickEvent(iv_mob17_round2)
        mobClickEvent(iv_mob18_round2)
        mobClickEvent(iv_mob19_round2)
        mobClickEvent(iv_mob20_round2)

        mobClickEvent(iv_mob21_round2)
        mobClickEvent(iv_mob22_round2)
        mobClickEvent(iv_mob23_round2)
        mobClickEvent(iv_mob24_round2)
        mobClickEvent(iv_mob25_round2)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()

        // 2라운드 17초 카운트 다운
        val intent1 = Intent(this, finishActivity::class.java)
        val intent2 = Intent(this, round3Activity::class.java)
        val countDown = object : CountDownTimer(1000 * 17, 1000) {
            override fun onTick(p0: Long) {
                // countDownInterval 마다 호출 (여기선 1000ms)
                binding.tvCount.text = (p0 / 1000).toString()
            }

            override fun onFinish() {
                mediaPlayer.pause()
                if(point > 12){
                    startActivity(intent2)
                }else {
                    intent1.putExtra("key", 0)
                    startActivity(intent1)
                }
            }
        }.start()
    }

    fun mobReset(mob: ImageView) {
        Glide.with(this).load(R.drawable.ibul_move).into(mob)
        mob.setTag("ibul")
    }

    fun mobEvent(mob: ImageView) {
        // 이미지 리스트
        var mobArraylist = ArrayList<Int>()
        mobArraylist.add(R.drawable.ibul_move)
        mobArraylist.add(R.drawable.kuzz_move)
        mobArraylist.add(R.drawable.cold_move)

        // 핸들러
        var handler = Handler(Looper.getMainLooper())
        val random = Random()
        val randomCount = random.nextInt(10000)

        Thread() {
            Thread.sleep(randomCount.toLong())
            for (i in mobArraylist) {
                handler.post {
                    Glide.with(this).load(i).into(mob)
                    when (i) {
                        R.drawable.ibul_move -> mob.setTag("ibul")
                        R.drawable.kuzz_move -> mob.setTag("kuzz")
                        else -> mob.setTag("cold")
                    }
                }
                Thread.sleep(2000)

                if (i == R.drawable.cold_move) {
                    handler.post {
                        Glide.with(this).load(R.drawable.cold_die).into(mob)
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
            if (mob.getTag() == "kuzz") {
                point += 1
                binding.tvPointRound2.text = point.toString()
                mobCount -= 1
                Glide.with(this).load(R.drawable.kuzz_die).into(mob)
                handler.postDelayed({
                    mob.visibility = View.INVISIBLE
                }, 660)
//                if (mobCount == 0) {
//                    if (point > 12) {
//                        mediaPlayer.pause()
//                        val intent = Intent(this, round3Activity::class.java)
//                        startActivity(intent)
//                    } else {
//                        mediaPlayer.pause()
//                        val intent = Intent(this, finishActivity::class.java)
//                        intent.putExtra("key", 0)
//                        startActivity(intent)
//                    }
//                }
            } else if (mob.getTag() == "ibul") {
                mobCount -= 1
                Glide.with(this).load(R.drawable.ibul_die).into(mob)
                handler.postDelayed({
                    mob.visibility = View.INVISIBLE
                }, 660)
//                if (mobCount == 0) {
//                    if (point > 12) {
//                        mediaPlayer.pause()
//                        val intent = Intent(this, round3Activity::class.java)
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
                Glide.with(this).load(R.drawable.cold_die).into(mob)
                handler.postDelayed({
                    mob.visibility = View.INVISIBLE
                }, 660)
//                if (mobCount == 0) {
//                    if (point > 12) {
//                        mediaPlayer.pause()
//                        val intent = Intent(this, round3Activity::class.java)
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