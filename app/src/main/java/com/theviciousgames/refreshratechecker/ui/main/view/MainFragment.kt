package com.theviciousgames.refreshratechecker.ui.main.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.theviciousgames.refreshratechecker.R
import com.theviciousgames.refreshratechecker.databinding.FragmentOnboardingBinding
import com.theviciousgames.refreshratechecker.ui.welcome.viewmodel.OnBoardingViewModel

class MainFragment : Fragment(R.layout.fragment_onboarding) {
    private var _binding: FragmentOnboardingBinding? = null
    private val viewModel: OnBoardingViewModel by viewModels()
    private val binding: FragmentOnboardingBinding
        get() = _binding!!

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun updateUi() {
        with(binding)
        {
            animationView.cancelAnimation()
            textviewTitle.text = "Change your DPI!"
            textviewDescription.text =
                "You either want to be a great gamer with a better aim or you simply want a zoomed-out screen and you came to the right place!\n Lets us know in a review what's your opinion!"

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateUi()
    }
}