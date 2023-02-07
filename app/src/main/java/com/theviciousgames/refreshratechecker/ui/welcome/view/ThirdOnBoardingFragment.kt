package com.theviciousgames.refreshratechecker.ui.welcome.view

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.theviciousgames.refreshratechecker.R
import com.theviciousgames.refreshratechecker.databinding.FragmentOnboardingBinding
import com.theviciousgames.refreshratechecker.ui.welcome.viewmodel.OnBoardingViewModel

class ThirdOnBoardingFragment : Fragment(R.layout.fragment_onboarding) {
    private var _binding: FragmentOnboardingBinding? = null
    private val viewModel: OnBoardingViewModel by viewModels()
    private val binding: FragmentOnboardingBinding
        get() = _binding!!

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setUserIsOld() {
        viewModel.setUserIsOld()
    }

    private fun updateUi() {
        with(binding)
        {
            animationView.visibility = View.VISIBLE
            textviewTitle.text = "Our website is waiting for you!"
            textviewDescription.text =
                "www.aBetterAndroid.com\nIf you're curious enough\n\uD83E\uDD14"
            animationView.setAnimation(R.raw.lottie_website)
            animationView.scaleType = ImageView.ScaleType.CENTER_CROP
            //buttonMoreApps.visibility = View.INVISIBLE
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateUi()
    }
}