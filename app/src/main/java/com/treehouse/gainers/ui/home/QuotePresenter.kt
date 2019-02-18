package com.treehouse.gainers.ui.home


import android.widget.TextView
import com.treehouse.gainers.R
import com.treehouse.gainers.model.ArrRequset
import com.treehouse.gainers.network.popServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuotePresenter(
    private val popServices: popServices,
    private val view: QuoteContract.View): QuoteContract.Presenter {
    override fun getQuoteDetails(symbol: String) {

        popServices.getQuoteDetails(symbol).enqueue(object : Callback<ArrRequset> {

            override fun onResponse(call: Call<ArrRequset>, response: Response<ArrRequset>) {

                if (response.isSuccessful) {

                    view.showResults(response.body()?.symbol ?: "")
                    }
                else {
                    view.showError("An unknown error occurred")
                }            }

            override fun onFailure(call: Call<ArrRequset>, t: Throwable) {
                view.showError("Please try again")
            }

        })
    }
}






