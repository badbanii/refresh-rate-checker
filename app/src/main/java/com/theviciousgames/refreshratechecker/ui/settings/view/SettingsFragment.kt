package com.theviciousgames.refreshratechecker.ui.settings.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.theviciousgames.refreshratechecker.R
import com.theviciousgames.refreshratechecker.databinding.FragmentOnboardingBinding
import com.theviciousgames.refreshratechecker.databinding.FragmentSettingsBinding
import com.theviciousgames.refreshratechecker.ui.welcome.viewmodel.OnBoardingViewModel

class SettingsFragment: Fragment(R.layout.fragment_settings) {
    private var _binding: FragmentSettingsBinding? = null
    private val viewModel: OnBoardingViewModel by viewModels()
    private val binding: FragmentSettingsBinding
        get() = _binding!!

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSettingsBinding.bind(view)
    }
}