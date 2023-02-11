package com.theviciousgames.refreshratechecker.ui.iap.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.theviciousgames.refreshratechecker.R
import com.theviciousgames.refreshratechecker.databinding.FragmentIapBinding
import com.theviciousgames.refreshratechecker.databinding.FragmentOnboardingBinding
import com.theviciousgames.refreshratechecker.ui.utils.Destination

class IapFragment:Fragment(R.layout.fragment_iap) {
    private val binding by viewBinding(FragmentIapBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonFunctions()
    }

    private fun navigateTo(destination: Destination)
    {
        when(destination)
        {
            Destination.Back->
            {
                if (findNavController().currentDestination?.id == com.theviciousgames.refreshratechecker.R.id.iapFragment)
                {
                    findNavController().navigateUp()
                }
            }
            else -> {}
        }
    }

    private fun buttonFunctions()
    {
        with(binding)
        {
            buttonBack.setOnClickListener {
                navigateTo(Destination.Back)
            }
        }
    }
}