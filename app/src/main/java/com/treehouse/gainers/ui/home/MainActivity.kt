package com.treehouse.gainers.ui.home

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.treehouse.gainers.App
import com.treehouse.gainers.ui.home.di.HomeModule
import com.treehouse.gainers.R
import com.treehouse.gainers.model.ArrResponse
import com.treehouse.gainers.ui.home.di.DaggerHomeComponent
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.second_activity.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HomeContract.View {

    private val StocksAdapter = StocksAdapter()
    @Inject
    lateinit var homePresenter: HomeContract.Presenter

    override fun showResults(result: List<ArrResponse>) {
        StocksAdapter.setData(result)    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerHomeComponent.builder()
            .appComponent((application as App).getComponent())
            .homeModule(HomeModule(this))
            .build()
            .inject(this)


        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = StocksAdapter

        btnShowStocks.setOnClickListener{ homePresenter.getStocksDetails(symbol = String()) }

        btnQuote.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)

    }



}}