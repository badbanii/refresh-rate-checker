package com.theviciousgames.refreshratechecker.ui.main.view

import android.R
import android.media.AudioAttributes
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.util.Log
import android.view.Display
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.theviciousgames.refreshratechecker.databinding.FragmentMainBinding
import com.theviciousgames.refreshratechecker.databinding.FragmentOnboardingBinding
import com.theviciousgames.refreshratechecker.ui.main.viewmodel.MainViewModel
import com.theviciousgames.refreshratechecker.ui.welcome.viewmodel.OnBoardingViewModel
import kotlin.concurrent.fixedRateTimer


class MainFragment : Fragment(com.theviciousgames.refreshratechecker.R.layout.fragment_main) {
    private var _binding: FragmentMainBinding? = null
    private val viewModel: MainViewModel by viewModels()
    private lateinit var modeAdapter: ModeAdapter
    private val binding: FragmentMainBinding
        get() = _binding!!

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun updateUi() {
        with(binding)
        {
            textviewRefreshRate.text="${getRefreshRate()}"
            var uri =
                Uri.parse("android.resource://" + "com.theviciousgames.refreshratechecker" + "/" + com.theviciousgames.refreshratechecker.R.raw.test)
            videoViewOne.setVideoURI(uri)
            videoViewOne.start()
            videoViewOne.setOnPreparedListener { mp -> mp.isLooping = true }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)
        updateUi()
        setupRecyclerView()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setupRecyclerView()
    {
        modeAdapter= ModeAdapter()
        with(binding)
        {
            recyclerviewModes.apply {
                adapter=modeAdapter
                layoutManager=LinearLayoutManager(activity)
            }
        }


        modeAdapter.differ.submitList(getAvailableRefreshRatesModes().distinctBy { it.refreshRate }.sortedBy { it.refreshRate })
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun getAvailableRefreshRatesModes(): Array<Display.Mode>
    {
       return viewModel.getAvailableRefreshRatesModes(requireActivity())
    }

    private fun getRefreshRate(): Int{
        return viewModel.getRefreshRate(requireActivity())
    }
    ///adb shell dumpsys display | grep -i "displaymoderecord" | grep -i "fps"
}