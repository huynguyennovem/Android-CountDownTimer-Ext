# Android-CountDownTimer-Ext
Android CountDownTimer supports pause and resume

**How to use**

```kotlin

// Init timer
lateinit var timerExt: CountDownTimerExt

timerExt = object : CountDownTimerExt(TIMER_DURATION, TIMER_INTERVAL) {
    override fun onTimerTick(millisUntilFinished: Long) {
        Log.d("MainActivity", "onTimerTick $millisUntilFinished")
    }

    override fun onTimerFinish() {
        Log.d("MainActivity", "onTimerFinish")
    }

}

// Start/Resume timer
timerExt.start()

// Pause timer
timerExt.pause()

// Restart timer
timerExt.restart()

```
