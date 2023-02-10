package com.theviciousgames.refreshratechecker.ui.main.viewmodel

import android.app.Activity
import android.os.Build
import android.view.Display
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.theviciousgames.refreshratechecker.ui.main.wm.WmUtils

class MainViewModel():ViewModel() {
    private var wmUtils=WmUtils()

    @RequiresApi(Build.VERSION_CODES.M)
    fun getAvailableRefreshRatesModes(activity: Activity):Array<Display.Mode>
    {
        return wmUtils.getAvailableRefreshRatesModes(activity)
    }

}