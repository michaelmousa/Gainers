package com.treehouse.gainers.ui.home

import com.treehouse.gainers.model.ArrResponse


interface HomeContract{

    interface View {
        fun showResults(result: List<ArrResponse>)
        fun showError(message: String)
    }
    interface Presenter{
        fun getStocksDetails(symbol:String)


    }
}

