package com.theviciousgames.refreshratechecker.ui.main.view

import android.media.PlaybackParams
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.Display
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.maxkeppeler.sheets.core.SheetStyle
import com.maxkeppeler.sheets.info.InfoSheet
import com.theviciousgames.refreshratechecker.databinding.FragmentMainBinding
import com.theviciousgames.refreshratechecker.ui.main.viewmodel.MainViewModel
import com.theviciousgames.refreshratechecker.ui.utils.Destination


class MainFragment : Fragment(com.theviciousgames.refreshratechecker.R.layout.fragment_main) {
    private var _binding: FragmentMainBinding? = null
    private val viewModel: MainViewModel by viewModels()
    private lateinit var modeAdapter: ModeAdapter
    private var dialog: InfoSheet = InfoSheet()
    private var currentRefreshRate=0
    private val binding: FragmentMainBinding
        get() = _binding!!

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun updateUi() {
        with(binding)
        {
            textviewRefreshRate.text="${getRefreshRate()}"
            var uri =
                Uri.parse("android.resource://" + "com.theviciousgames.refreshratechecker" + "/" + com.theviciousgames.refreshratechecker.R.raw.test)
            videoViewOne.setVideoURI(uri)
            videoViewOne.start()
            videoViewOne.setOnPreparedListener { mp -> mp.isLooping = true}
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)
        buttonFunctions()
        updateUi()
        setupRecyclerView()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun refresh()
    {
        binding.textviewRefreshRate.text=getRefreshRate().toString()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun buttonFunctions()
    {
        with(binding){
            buttonMenu.setOnClickListener {
                navigateTo(Destination.Menu)
            }
            buttonDemoInfo.setOnClickListener {
                showDialogDemo()
            }
            buttonModesInfo.setOnClickListener {
                showDialogModes()
            }
            buttonRefreshRateInfo.setOnClickListener {
                showDialogDefinition()
            }
            buttonRefresh.setOnClickListener {
                refresh()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setupRecyclerView()
    {
        modeAdapter= ModeAdapter()
        with(binding)
        {
            recyclerviewModes.apply {
                adapter=modeAdapter
                layoutManager=LinearLayoutManager(activity)
            }
        }
        modeAdapter.differ.submitList(getAvailableRefreshRatesModes().distinctBy { it.refreshRate }.sortedBy { it.refreshRate })
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun getAvailableRefreshRatesModes(): Array<Display.Mode>
    {
       return viewModel.getAvailableRefreshRatesModes(requireActivity())
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun getRefreshRate(): Int{
        return viewModel.getRefreshRate(requireActivity())
    }

    private fun navigateTo(destination: Destination)
    {
        when(destination)
        {
            Destination.Menu->
            {
                if (findNavController().currentDestination?.id == com.theviciousgames.refreshratechecker.R.id.mainFragment)
                {
                    findNavController().navigate(com.theviciousgames.refreshratechecker.R.id.action_mainFragment_to_menuFragment)
                }
            }
            Destination.Settings->{
                if (findNavController().currentDestination?.id == com.theviciousgames.refreshratechecker.R.id.mainFragment)
                {
                    findNavController().navigate(com.theviciousgames.refreshratechecker.R.id.action_mainFragment_to_settingsFragment)
                }
            }

            else -> {}
        }
    }

    private fun showDialogDemo() {
        dialog = InfoSheet().build(requireActivity()) {
            title("INFO")
            displayNegativeButton(false)
            style(SheetStyle.DIALOG)
            content("This is a visual representation of your device refresh rate.")
            onPositive("Close") {
            }
        }
        dialog.show()
    }

    private fun showDialogModes() {
        dialog = InfoSheet().build(requireActivity()) {
            title("INFO")
            displayNegativeButton(false)
            style(SheetStyle.DIALOG)
            content("These are all the available display modes on your device (available refresh rate).")
            onPositive("Close") {
            }
        }
        dialog.show()
    }

    private fun showDialogDefinition() {
        dialog = InfoSheet().build(requireActivity()) {
            title("INFO")
            displayNegativeButton(false)
            style(SheetStyle.DIALOG)
            content("Short definition of what refresh rate is.")
            onPositive("Close") {
            }
        }
        dialog.show()
    }
}