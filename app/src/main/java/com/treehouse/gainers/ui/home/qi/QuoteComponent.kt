package com.treehouse.gainers.ui.home.qi

import com.treehouse.gainers.retrofit.AppComponent
import com.treehouse.gainers.ui.home.SecondActivity
import com.treehouse.gainers.ui.home.di.HomeScope
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [QuoteModule::class])
@HomeScope
interface QuoteComponent {
    fun inject(secondActivity: SecondActivity)
}