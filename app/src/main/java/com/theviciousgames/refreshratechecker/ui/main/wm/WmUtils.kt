package com.theviciousgames.refreshratechecker.ui.main.wm

import android.app.Activity
import android.os.Build
import android.util.DisplayMetrics
import android.view.Display
import androidx.annotation.RequiresApi
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

class WmUtils {
    private lateinit var modes:Array<Display.Mode>

    @RequiresApi(Build.VERSION_CODES.M)
    fun getAvailableRefreshRatesModes(activity: Activity):Array<Display.Mode>{

        modes = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            activity.display!!.supportedModes
        } else {
            activity.windowManager.defaultDisplay.supportedModes
        }
        return modes
    }

}