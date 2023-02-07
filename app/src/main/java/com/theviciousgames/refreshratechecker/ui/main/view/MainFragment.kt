package com.theviciousgames.refreshratechecker.ui.main.view

import android.R
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.theviciousgames.refreshratechecker.databinding.FragmentMainBinding
import com.theviciousgames.refreshratechecker.ui.welcome.viewmodel.OnBoardingViewModel


class MainFragment : Fragment(com.theviciousgames.refreshratechecker.R.layout.fragment_main) {
    private var _binding: FragmentMainBinding? = null
    private val viewModel: OnBoardingViewModel by viewModels()
    private val binding: FragmentMainBinding
        get() = _binding!!

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun updateUi() {
        with(binding)
        {
            val uri = Uri.parse("android.resource://" + "com.theviciousgames.refreshratechecker" + "/" + com.theviciousgames.refreshratechecker.R.raw.test)
            videoView.setVideoURI(uri)
            videoView.start()
            videoView.setOnPreparedListener { mp -> mp.isLooping = true }

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateUi()
    }
}