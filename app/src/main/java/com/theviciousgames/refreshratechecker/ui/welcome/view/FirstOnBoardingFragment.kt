package com.theviciousgames.refreshratechecker.ui.welcome.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.theviciousgames.refreshratechecker.R
import com.theviciousgames.refreshratechecker.databinding.FragmentOnboardingBinding
import com.theviciousgames.refreshratechecker.ui.utils.Destination
import com.theviciousgames.refreshratechecker.ui.welcome.viewmodel.OnBoardingViewModel

class FirstOnBoardingFragment : Fragment(R.layout.fragment_onboarding) {
    private var _binding: FragmentOnboardingBinding? = null
    private val viewModel: OnBoardingViewModel by viewModels()
    private val binding: FragmentOnboardingBinding
        get() = _binding!!

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

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
            animationView.cancelAnimation()
            textviewTitle.text = "Check your refresh!"
            textviewDescription.text =
                "You either want to be a great gamer with a better aim or you simply want a zoomed-out screen and you came to the right place!\n Lets us know in a review what's your opinion!"
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
        _binding = FragmentOnboardingBinding.bind(view)
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