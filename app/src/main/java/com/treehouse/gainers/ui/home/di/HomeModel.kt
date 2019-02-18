package com.treehouse.gainers.ui.home.di

import com.treehouse.gainers.network.popServices
import com.treehouse.gainers.ui.home.HomeContract
import com.treehouse.gainers.ui.home.HomePresenter
import dagger.Module
import dagger.Provides

@Module
class HomeModule(private val view: HomeContract.View) {


    @HomeScope
    @Provides
    fun provideHomePresenter(popServices: popServices)
            : HomeContract.Presenter {
        return HomePresenter(popServices, view)
    }
}