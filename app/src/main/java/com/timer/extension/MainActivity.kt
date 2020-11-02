package com.timer.extension

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var timerExt: CountDownTimerExt

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timerExt = object : CountDownTimerExt(TIMER_DURATION, TIMER_INTERVAL) {
            override fun onTimerTick(millisUntilFinished: Long) {
                Log.d("TAG", "onTimerTick $millisUntilFinished")
                tvTime.text = (millisUntilFinished / TIMER_INTERVAL).toString()
            }

            override fun onTimerFinish() {
                Log.d("TAG", "onTimerFinish")
                tvTime.text = "0"
            }

        }

        btnStart.setOnClickListener {
            timerExt.start()
        }

        btnPause.setOnClickListener {
            timerExt.pause()
        }

        btnRestart.setOnClickListener {
            timerExt.restart()
            tvTime.text = "0"
        }

    }

    override fun onPause() {
        super.onPause()
        timerExt.pause()
    }

    override fun onResume() {
        super.onResume()
        timerExt.start()
    }

    override fun onDestroy() {
        timerExt.restart()
        super.onDestroy()
    }

    companion object {
        const val TIMER_DURATION = 3000L
        const val TIMER_INTERVAL = 1000L
    }

}