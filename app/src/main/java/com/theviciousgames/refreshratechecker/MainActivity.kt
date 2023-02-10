package com.theviciousgames.refreshratechecker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatDelegate
import com.suddenh4x.ratingdialog.AppRating
import com.suddenh4x.ratingdialog.preferences.RatingThreshold

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        forceDayMode()
        keepScreenAwake()

        if (savedInstanceState == null) {
            rateApp()
        }
    }

    private fun forceDayMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    private fun keepScreenAwake() {
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
    }

    private fun rateApp() {
        AppRating.Builder(this)
            .setMinimumLaunchTimes(5)
            .setMinimumDays(3)
            .setMinimumLaunchTimesToShowAgain(5)
            .setMinimumDaysToShowAgain(5)
            .setRatingThreshold(RatingThreshold.FOUR)
            .showIfMeetsConditions()
    }
}