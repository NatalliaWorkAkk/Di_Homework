package com.effectivemobile.dihomework

import android.app.Application
import com.effectivemobile.dihomework.di.AppComponent
import com.effectivemobile.dihomework.di.DaggerAppComponent

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().context(this).build()
    }

    companion object {
        var appComponent: AppComponent? = null
    }
}