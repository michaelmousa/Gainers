package com.treehouse.gainers

import android.app.Application
import com.treehouse.gainers.retrofit.AppComponent
import com.treehouse.gainers.retrofit.DaggerAppComponent

class App : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .build();
    }

    fun getComponent() = appComponent
}