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
import com.example.risingcamp4week.databinding.ActivityRound3Binding
import java.util.*
import kotlin.collections.ArrayList

class round3Activity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer              // 음악실행
    private var point: Int = 0                                 // 획득 점수
    private var mobCount: Int = 49                             // 몹수, 0되면 종료
    private lateinit var binding: ActivityRound3Binding        // 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRound3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // 음악 시작, 앱종료시까지 유지
        mediaPlayer = MediaPlayer.create(this, R.raw.snowyvillage)
//        mediaPlayer.setLooping(true) //무한재생
        mediaPlayer.start()

        /* 변수 설정 */
        val warr3 = binding.ivWarr3     //전사
        //몹
        val iv_mob1_round3 = binding.ivMob1Round3
        val iv_mob2_round3 = binding.ivMob2Round3
        val iv_mob3_round3 = binding.ivMob3Round3
        val iv_mob4_round3 = binding.ivMob4Round3
        val iv_mob5_round3 = binding.ivMob5Round3
        val iv_mob6_round3 = binding.ivMob6Round3
        val iv_mob7_round3 = binding.ivMob7Round3
        val iv_mob8_round3 = binding.ivMob8Round3
        val iv_mob9_round3 = binding.ivMob9Round3
        val iv_mob10_round3 = binding.ivMob10Round3

        val iv_mob11_round3 = binding.ivMob11Round3
        val iv_mob12_round3 = binding.ivMob12Round3
        val iv_mob13_round3 = binding.ivMob13Round3
        val iv_mob14_round3 = binding.ivMob14Round3
        val iv_mob15_round3 = binding.ivMob15Round3
        val iv_mob16_round3 = binding.ivMob16Round3
        val iv_mob17_round3 = binding.ivMob17Round3
        val iv_mob18_round3 = binding.ivMob18Round3
        val iv_mob19_round3 = binding.ivMob19Round3
        val iv_mob20_round3 = binding.ivMob20Round3

        val iv_mob21_round3 = binding.ivMob21Round3
        val iv_mob22_round3 = binding.ivMob22Round3
        val iv_mob23_round3 = binding.ivMob23Round3
        val iv_mob24_round3 = binding.ivMob24Round3
        val iv_mob25_round3 = binding.ivMob25Round3
        val iv_mob26_round3 = binding.ivMob26Round3
        val iv_mob27_round3 = binding.ivMob27Round3
        val iv_mob28_round3 = binding.ivMob28Round3
        val iv_mob29_round3 = binding.ivMob29Round3
        val iv_mob30_round3 = binding.ivMob30Round3

        val iv_mob31_round3 = binding.ivMob31Round3
        val iv_mob32_round3 = binding.ivMob32Round3
        val iv_mob33_round3 = binding.ivMob33Round3
        val iv_mob34_round3 = binding.ivMob34Round3
        val iv_mob35_round3 = binding.ivMob35Round3
        val iv_mob36_round3 = binding.ivMob36Round3
        val iv_mob37_round3 = binding.ivMob37Round3
        val iv_mob38_round3 = binding.ivMob38Round3
        val iv_mob39_round3 = binding.ivMob39Round3
        val iv_mob40_round3 = binding.ivMob40Round3

        val iv_mob41_round3 = binding.ivMob41Round3
        val iv_mob42_round3 = binding.ivMob42Round3
        val iv_mob43_round3 = binding.ivMob43Round3
        val iv_mob44_round3 = binding.ivMob44Round3
        val iv_mob45_round3 = binding.ivMob45Round3
        val iv_mob46_round3 = binding.ivMob46Round3
        val iv_mob47_round3 = binding.ivMob47Round3
        val iv_mob48_round3 = binding.ivMob48Round3
        val iv_mob49_round3 = binding.ivMob49Round3

        //점수
        val tvpointround3 = binding.tvPointRound3

        /* 애니메이션 적용 */
        Glide.with(this).load(R.drawable.warr3_move).into(warr3)

        // 몹 초기화
        mobReset(iv_mob1_round3)
        mobReset(iv_mob2_round3)
        mobReset(iv_mob3_round3)
        mobReset(iv_mob4_round3)
        mobReset(iv_mob5_round3)
        mobReset(iv_mob6_round3)
        mobReset(iv_mob7_round3)
        mobReset(iv_mob8_round3)
        mobReset(iv_mob9_round3)
        mobReset(iv_mob10_round3)

        mobReset(iv_mob11_round3)
        mobReset(iv_mob12_round3)
        mobReset(iv_mob13_round3)
        mobReset(iv_mob14_round3)
        mobReset(iv_mob15_round3)
        mobReset(iv_mob16_round3)
        mobReset(iv_mob17_round3)
        mobReset(iv_mob18_round3)
        mobReset(iv_mob19_round3)
        mobReset(iv_mob20_round3)

        mobReset(iv_mob21_round3)
        mobReset(iv_mob22_round3)
        mobReset(iv_mob23_round3)
        mobReset(iv_mob24_round3)
        mobReset(iv_mob25_round3)
        mobReset(iv_mob26_round3)
        mobReset(iv_mob27_round3)
        mobReset(iv_mob28_round3)
        mobReset(iv_mob29_round3)
        mobReset(iv_mob30_round3)

        mobReset(iv_mob31_round3)
        mobReset(iv_mob32_round3)
        mobReset(iv_mob33_round3)
        mobReset(iv_mob34_round3)
        mobReset(iv_mob35_round3)
        mobReset(iv_mob36_round3)
        mobReset(iv_mob37_round3)
        mobReset(iv_mob38_round3)
        mobReset(iv_mob39_round3)
        mobReset(iv_mob40_round3)

        mobReset(iv_mob41_round3)
        mobReset(iv_mob42_round3)
        mobReset(iv_mob43_round3)
        mobReset(iv_mob44_round3)
        mobReset(iv_mob45_round3)
        mobReset(iv_mob46_round3)
        mobReset(iv_mob47_round3)
        mobReset(iv_mob48_round3)
        mobReset(iv_mob49_round3)

        // mob 쓰레드
        mobEvent(iv_mob1_round3)
        mobEvent(iv_mob2_round3)
        mobEvent(iv_mob3_round3)
        mobEvent(iv_mob4_round3)
        mobEvent(iv_mob5_round3)
        mobEvent(iv_mob6_round3)
        mobEvent(iv_mob7_round3)
        mobEvent(iv_mob8_round3)
        mobEvent(iv_mob9_round3)
        mobEvent(iv_mob10_round3)

        mobEvent(iv_mob11_round3)
        mobEvent(iv_mob12_round3)
        mobEvent(iv_mob13_round3)
        mobEvent(iv_mob14_round3)
        mobEvent(iv_mob15_round3)
        mobEvent(iv_mob16_round3)
        mobEvent(iv_mob17_round3)
        mobEvent(iv_mob18_round3)
        mobEvent(iv_mob19_round3)
        mobEvent(iv_mob20_round3)

        mobEvent(iv_mob21_round3)
        mobEvent(iv_mob22_round3)
        mobEvent(iv_mob23_round3)
        mobEvent(iv_mob24_round3)
        mobEvent(iv_mob25_round3)
        mobEvent(iv_mob26_round3)
        mobEvent(iv_mob27_round3)
        mobEvent(iv_mob28_round3)
        mobEvent(iv_mob29_round3)
        mobEvent(iv_mob30_round3)

        mobEvent(iv_mob31_round3)
        mobEvent(iv_mob32_round3)
        mobEvent(iv_mob33_round3)
        mobEvent(iv_mob34_round3)
        mobEvent(iv_mob35_round3)
        mobEvent(iv_mob36_round3)
        mobEvent(iv_mob37_round3)
        mobEvent(iv_mob38_round3)
        mobEvent(iv_mob39_round3)
        mobEvent(iv_mob40_round3)

        mobEvent(iv_mob41_round3)
        mobEvent(iv_mob42_round3)
        mobEvent(iv_mob43_round3)
        mobEvent(iv_mob44_round3)
        mobEvent(iv_mob45_round3)
        mobEvent(iv_mob46_round3)
        mobEvent(iv_mob47_round3)
        mobEvent(iv_mob48_round3)
        mobEvent(iv_mob49_round3)

        // mob 버튼 클릭
        mobClickEvent(iv_mob1_round3)
        mobClickEvent(iv_mob2_round3)
        mobClickEvent(iv_mob3_round3)
        mobClickEvent(iv_mob4_round3)
        mobClickEvent(iv_mob5_round3)
        mobClickEvent(iv_mob6_round3)
        mobClickEvent(iv_mob7_round3)
        mobClickEvent(iv_mob8_round3)
        mobClickEvent(iv_mob9_round3)
        mobClickEvent(iv_mob10_round3)

        mobClickEvent(iv_mob11_round3)
        mobClickEvent(iv_mob12_round3)
        mobClickEvent(iv_mob13_round3)
        mobClickEvent(iv_mob14_round3)
        mobClickEvent(iv_mob15_round3)
        mobClickEvent(iv_mob16_round3)
        mobClickEvent(iv_mob17_round3)
        mobClickEvent(iv_mob18_round3)
        mobClickEvent(iv_mob19_round3)
        mobClickEvent(iv_mob20_round3)

        mobClickEvent(iv_mob21_round3)
        mobClickEvent(iv_mob22_round3)
        mobClickEvent(iv_mob23_round3)
        mobClickEvent(iv_mob24_round3)
        mobClickEvent(iv_mob25_round3)
        mobClickEvent(iv_mob26_round3)
        mobClickEvent(iv_mob27_round3)
        mobClickEvent(iv_mob28_round3)
        mobClickEvent(iv_mob29_round3)
        mobClickEvent(iv_mob30_round3)

        mobClickEvent(iv_mob31_round3)
        mobClickEvent(iv_mob32_round3)
        mobClickEvent(iv_mob33_round3)
        mobClickEvent(iv_mob34_round3)
        mobClickEvent(iv_mob35_round3)
        mobClickEvent(iv_mob36_round3)
        mobClickEvent(iv_mob37_round3)
        mobClickEvent(iv_mob38_round3)
        mobClickEvent(iv_mob39_round3)
        mobClickEvent(iv_mob40_round3)

        mobClickEvent(iv_mob41_round3)
        mobClickEvent(iv_mob42_round3)
        mobClickEvent(iv_mob43_round3)
        mobClickEvent(iv_mob44_round3)
        mobClickEvent(iv_mob45_round3)
        mobClickEvent(iv_mob46_round3)
        mobClickEvent(iv_mob47_round3)
        mobClickEvent(iv_mob48_round3)
        mobClickEvent(iv_mob49_round3)

    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()

        // 3라운드 22초 카운트 다운
        val intent1 = Intent(this, finishActivity::class.java)
        val countDown = object : CountDownTimer(1000 * 27, 1000) {
            override fun onTick(p0: Long) {
                // countDownInterval 마다 호출 (여기선 1000ms)
                binding.tvCount.text = (p0 / 1000).toString()
            }

            override fun onFinish() {
                mediaPlayer.pause()
                if(point > 25){
                    intent1.putExtra("key", 1)
                    startActivity(intent1)
                }else {
                    intent1.putExtra("key", 0)
                    startActivity(intent1)
                }
            }
        }.start()
    }

    fun mobReset(mob: ImageView) {
        Glide.with(this).load(R.drawable.juni_move).into(mob)
        mob.setTag("juni")
    }

    fun mobEvent(mob: ImageView) {
        // 이미지 리스트
        var mobArraylist = ArrayList<Int>()
        mobArraylist.add(R.drawable.juni_move)
        mobArraylist.add(R.drawable.pepe_move)
        mobArraylist.add(R.drawable.dark_move)

        // 핸들러
        var handler = Handler(Looper.getMainLooper())
        val random = Random()
        val randomCount = random.nextInt(20000)

        Thread() {
            Thread.sleep(randomCount.toLong())
            for (i in mobArraylist) {
                handler.post {
                    Glide.with(this).load(i).into(mob)
                    when (i) {
                        R.drawable.juni_move -> mob.setTag("juni")
                        R.drawable.pepe_move -> mob.setTag("pepe")
                        else -> mob.setTag("dark")
                    }
                }
                Thread.sleep(2000)
                if (i == R.drawable.dark_move) {
                    handler.post {
                        Glide.with(this).load(R.drawable.dark_die).into(mob)
                    }
                    handler.postDelayed({
                        mob.visibility = View.INVISIBLE
                    }, 750)
                }
            }
        }.start()
    }

    fun mobClickEvent(mob: ImageView) {
        // 핸들러
        var handler = Handler(Looper.getMainLooper())
        // mob1 버튼 클릭
        mob.setOnClickListener {
            if (mob.getTag() == "pepe") {
                point += 1
                binding.tvPointRound3.text = point.toString()
                mobCount -= 1
                Glide.with(this).load(R.drawable.pepe_die).into(mob)
                handler.postDelayed({
                    mob.visibility = View.INVISIBLE
                }, 750)
//                if (mobCount == 0) {
//                    if (point > 24) {
//                        mediaPlayer.pause()
//                        val intent = Intent(this, finishActivity::class.java)
//                        intent.putExtra("key", 1)
//                        startActivity(intent)
//                    } else {
//                        mediaPlayer.pause()
//                        val intent = Intent(this, finishActivity::class.java)
//                        intent.putExtra("key", 0)
//                        startActivity(intent)
//                    }
//                }
            } else if (mob.getTag() == "juni") {
                mobCount -= 1
                Glide.with(this).load(R.drawable.juni_die).into(mob)
                handler.postDelayed({
                    mob.visibility = View.INVISIBLE
                }, 900)
//                if (mobCount == 0) {
//                    if (point > 24) {
//                        mediaPlayer.pause()
//                        val intent = Intent(this, finishActivity::class.java)
//                        intent.putExtra("key", 1)
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
                Glide.with(this).load(R.drawable.dark_die).into(mob)
                handler.postDelayed({
                    mob.visibility = View.INVISIBLE
                }, 750)
//                if (mobCount == 0) {
//                    if (point > 24) {
//                        mediaPlayer.pause()
//                        val intent = Intent(this, finishActivity::class.java)
//                        intent.putExtra("key", 1)
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