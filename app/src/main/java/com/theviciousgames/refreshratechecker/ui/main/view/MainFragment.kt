package com.theviciousgames.refreshratechecker.ui.main.view

import android.R
import android.media.AudioAttributes
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.theviciousgames.refreshratechecker.databinding.FragmentMainBinding
import com.theviciousgames.refreshratechecker.databinding.FragmentOnboardingBinding
import com.theviciousgames.refreshratechecker.ui.main.viewmodel.MainViewModel
import com.theviciousgames.refreshratechecker.ui.welcome.viewmodel.OnBoardingViewModel
import kotlin.concurrent.fixedRateTimer


class MainFragment : Fragment(com.theviciousgames.refreshratechecker.R.layout.fragment_main) {
    private var _binding: FragmentMainBinding? = null
    private val viewModel: MainViewModel by viewModels()
    private val binding: FragmentMainBinding
        get() = _binding!!

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun updateUi() {
        with(binding)
        {
            var uri =
                Uri.parse("android.resource://" + "com.theviciousgames.refreshratechecker" + "/" + com.theviciousgames.refreshratechecker.R.raw.test)
            videoViewOne.setVideoURI(uri)
            videoViewOne.start()
            videoViewOne.setOnPreparedListener { mp -> mp.isLooping = true }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)
        updateUi()
    }
    ///adb shell dumpsys display | grep -i "displaymoderecord" | grep -i "fps"
}