package com.treehouse.gainers.ui.home.di

import com.treehouse.gainers.retrofit.AppComponent
import com.treehouse.gainers.ui.home.MainActivity
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [HomeModule::class])
@HomeScope
interface HomeComponent {
    fun inject(mainActivity: MainActivity)
}