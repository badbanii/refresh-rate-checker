package com.theviciousgames.refreshratechecker.ui.welcome.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.theviciousgames.refreshratechecker.R
import com.theviciousgames.refreshratechecker.databinding.FragmentOnboardingBinding
import com.theviciousgames.refreshratechecker.ui.utils.Destination
import com.theviciousgames.refreshratechecker.ui.welcome.viewmodel.OnBoardingViewModel

class FirstOnBoardingFragment : Fragment(R.layout.fragment_onboarding) {
    private val binding by viewBinding(FragmentOnboardingBinding::bind)
    private val viewModel: OnBoardingViewModel by viewModels()

    private fun navigateToMainIfUserIsOld()
    {
        if(viewModel.getUserIsOld())
        {
            navigateTo(Destination.Main)
        }
    }
    private fun updateUi() {
        navigateToMainIfUserIsOld()
        with(binding)
        {
            lottieView.cancelAnimation()
            textviewTitle.text = "Refresh rate matters!"
            textviewDescription.text =
                "Your device's refresh rate is important. A smooth UI provides a better user experience. Playing games at a higher refresh rate can have a substantial impact on your gaming experience. This is especially relevant with fast-paced, competitive games where every frame counts.\nLets us know in a review what's your opinion!"
        }
    }

    private fun navigateTo(destination: Destination)
    {
            when(destination)
            {
                Destination.SecondOnBoarding->
                {
                    if (findNavController().currentDestination?.id == R.id.firstOnBoardingFragment)
                    {
                        findNavController().navigate(R.id.action_firstOnBoardingFragment_to_secondOnBoardingFragment)
                    }
                }
                Destination.Main->{
                    if (findNavController().currentDestination?.id == R.id.firstOnBoardingFragment)
                    {
                        findNavController().navigate(R.id.action_firstOnBoardingFragment_to_mainFragment)
                    }
                }
                else -> {}
            }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateUi()
        buttonFunction()
    }

    private fun buttonFunction()
    {
        with(binding)
        {
            buttonNext.setOnClickListener {
                navigateTo(Destination.SecondOnBoarding)
            }
        }
    }
}