package com.theviciousgames.refreshratechecker.ui.menu.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.theviciousgames.refreshratechecker.R
import com.theviciousgames.refreshratechecker.databinding.FragmentMainBinding
import com.theviciousgames.refreshratechecker.databinding.FragmentMenuBinding
import com.theviciousgames.refreshratechecker.databinding.FragmentOnboardingBinding
import com.theviciousgames.refreshratechecker.databinding.FragmentSettingsBinding
import com.theviciousgames.refreshratechecker.ui.main.view.ModeAdapter
import com.theviciousgames.refreshratechecker.ui.menu.viewmodel.MenuViewModel
import com.theviciousgames.refreshratechecker.ui.welcome.viewmodel.OnBoardingViewModel

class MenuFragment: Fragment(R.layout.fragment_menu) {
    private var _binding: FragmentMenuBinding? = null
    private val viewModel: MenuViewModel by viewModels()

    private val binding: FragmentMenuBinding
        get() = _binding!!

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMenuBinding.bind(view)
    }


}