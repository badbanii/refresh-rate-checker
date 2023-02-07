package com.theviciousgames.refreshratechecker.ui.welcome.view

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.theviciousgames.refreshratechecker.R
import com.theviciousgames.refreshratechecker.databinding.FragmentOnboardingBinding
import com.theviciousgames.refreshratechecker.ui.welcome.viewmodel.OnBoardingViewModel

class SecondOnBoardingFragment : Fragment(R.layout.fragment_onboarding) {
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
            textviewTitle.text = "Check out our other apps!"
            textviewDescription.text =
                "Are you looking to change your resolution? Check your device's HDR version?\nVisit us by pressing 'more'!\naBetterAndroid has everything you need."
            animationView.visibility = View.VISIBLE
            animationView.setAnimation(R.raw.lottie_more)
            animationView.scaleType = ImageView.ScaleType.CENTER_CROP
           // buttonMoreApps.visibility = View.VISIBLE
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateUi()
    }

}