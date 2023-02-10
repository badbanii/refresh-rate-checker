package com.theviciousgames.refreshratechecker.ui.menu.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.suddenh4x.ratingdialog.AppRating
import com.theviciousgames.refreshratechecker.R
import com.theviciousgames.refreshratechecker.databinding.FragmentMainBinding
import com.theviciousgames.refreshratechecker.databinding.FragmentMenuBinding
import com.theviciousgames.refreshratechecker.databinding.FragmentOnboardingBinding
import com.theviciousgames.refreshratechecker.databinding.FragmentSettingsBinding
import com.theviciousgames.refreshratechecker.ui.main.view.ModeAdapter
import com.theviciousgames.refreshratechecker.ui.menu.viewmodel.MenuViewModel
import com.theviciousgames.refreshratechecker.ui.utils.Destination
import com.theviciousgames.refreshratechecker.ui.welcome.viewmodel.OnBoardingViewModel
import kotlin.system.exitProcess

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
        buttonFunctions()
    }

    private fun buttonFunctions()
    {
        with(binding){
            buttonBack.setOnClickListener {
                navigateTo(Destination.Back)
            }
            buttonShare.setOnClickListener {
                showSharingDialog()
            }
            buttonApps.setOnClickListener {
                showPlayStoreProfile()
            }
            buttonQuit.setOnClickListener {
                closeApp()
            }
            buttonRate.setOnClickListener {
                showRatingDialog()
            }
        }
    }

    private fun showRatingDialog()
    {
        AppRating.Builder(requireActivity()).showNow()
    }
    private fun showPlayStoreProfile() {
        startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://play.google.com/store/apps/dev?id=8049005269403185530")
            )
        )
    }

    private fun closeApp() {
        ActivityCompat.finishAffinity(requireActivity())
        requireActivity().finish()
        exitProcess(0)
    }
    private fun navigateTo(destination: Destination)
    {
        when(destination)
        {
            Destination.Back->
            {
                if (findNavController().currentDestination?.id == com.theviciousgames.refreshratechecker.R.id.menuFragment)
                {
                    findNavController().navigateUp()
                }
            }
            else -> {}
        }
    }

    private fun showSharingDialog() {
        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        intent.type = "text/plain"
        intent.putExtra(
            Intent.EXTRA_TEXT,
            "Refresh Rate Checker:\nhttps://play.google.com/store/apps/details?id=com.theviciousgames.refreshratechecker"
        )
        startActivity(Intent.createChooser(intent, "Share with:"))
    }
}