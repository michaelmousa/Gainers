package com.treehouse.gainers.ui.home.qi

import com.treehouse.gainers.network.popServices
import com.treehouse.gainers.ui.home.QuoteContract
import com.treehouse.gainers.ui.home.QuotePresenter
import com.treehouse.gainers.ui.home.di.HomeScope
import dagger.Module
import dagger.Provides

@Module
class QuoteModule(private val view: QuoteContract.View) {


    @HomeScope
    @Provides
    fun provideQuotePresenter(popServices: popServices)
            : QuoteContract.Presenter {
        return QuotePresenter(popServices, view)
    }
}