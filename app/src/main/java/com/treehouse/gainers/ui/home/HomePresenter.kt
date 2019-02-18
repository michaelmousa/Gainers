package com.treehouse.gainers.ui.home

import com.treehouse.gainers.model.ArrRequset
import com.treehouse.gainers.model.ArrResponse
import com.treehouse.gainers.network.popServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter  (

    private val popServices: popServices,
    private val view: HomeContract.View) : HomeContract.Presenter
{
    override fun getStocksDetails(symbol: String) {
    popServices.getStocksDetails().enqueue(object : Callback<List<ArrResponse>>

    {
        override fun onFailure(call: Call<List<ArrResponse>>, t: Throwable) {
            view.showError("Please try again")

        }
        override fun onResponse(call: Call<List<ArrResponse>>, response: Response<List<ArrResponse>>) {

            if (response.isSuccessful) {
                view.showResults(response.body()?: emptyList())
            } else {
                view.showError("An unknown error occurred")
            }
        }
    })
    }}


