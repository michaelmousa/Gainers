package com.treehouse.gainers.ui.home

import com.treehouse.gainers.model.ArrRequset

interface QuoteContract {


    interface View {
        fun showResults(result: String)
        fun showError(message: String)

    }
    interface Presenter{
        fun getQuoteDetails(symbol:String)


    }
}