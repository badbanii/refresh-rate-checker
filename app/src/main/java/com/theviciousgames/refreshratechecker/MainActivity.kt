package com.theviciousgames.refreshratechecker

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.suddenh4x.ratingdialog.AppRating
import com.suddenh4x.ratingdialog.preferences.RatingThreshold
import com.theviciousgames.refreshratechecker.databinding.ActivityMainBinding
import com.theviciousgames.refreshratechecker.databinding.FragmentOnboardingBinding

class MainActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityMainBinding::bind)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        forceDayMode()
        keepScreenAwake()

        if (savedInstanceState == null) {
            rateApp()
        }

    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val navController = binding.navigationHost.findNavController()

        when (navController.currentDestination?.id) {
            R.id.firstOnBoardingFragment -> {

            }

            R.id.secondOnBoardingFragment -> {

            }

            R.id.thirdOnBoardingFragment -> {

            }

            R.id.mainFragment -> {

            }

            R.id.menuFragment -> {

            }

            R.id.settingsFragment -> {

            }

            else -> {
                super.onBackPressed()
            }
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