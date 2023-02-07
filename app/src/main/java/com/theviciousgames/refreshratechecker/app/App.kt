package com.theviciousgames.refreshratechecker.app

import android.app.Application
import com.fxn.stash.Stash

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        initStash()
    }

    private fun initStash() {
        Stash.init(this)
    }
}