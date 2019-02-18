package com.treehouse.gainers.ui.home

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast
import com.treehouse.gainers.App
import com.treehouse.gainers.R
import com.treehouse.gainers.model.ArrRequset
import com.treehouse.gainers.ui.home.di.DaggerHomeComponent
import com.treehouse.gainers.ui.home.di.HomeModule
import com.treehouse.gainers.ui.home.qi.DaggerQuoteComponent
import com.treehouse.gainers.ui.home.qi.QuoteModule
import kotlinx.android.synthetic.main.second_activity.*
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class SecondActivity : AppCompatActivity(),QuoteContract.View {
    @Inject
    lateinit var quotePresenter: QuoteContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        DaggerQuoteComponent.builder()
            .appComponent((application as App).getComponent())
            .quoteModule(QuoteModule(this))
            .build()
            .inject(this)

        btnShowQuote.setOnClickListener {
            quotePresenter.getQuoteDetails(editText.text.toString()) }
    }
    override fun showResults(result: String) {
        tvResult.text = result
    }
    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()    }

    }


