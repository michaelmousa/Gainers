package com.treehouse.gainers.network


import com.treehouse.gainers.model.ArrRequset
import com.treehouse.gainers.model.ArrResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface popServices {

    @GET(END_POINT)

    fun getStocksDetails()
            : Call<List<ArrResponse>>

    @GET(BASE_URL_TWO)
    fun getQuoteDetails(@Path("symbol") symbol: String): Call<ArrRequset>
}