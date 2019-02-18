package com.treehouse.gainers.ui.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.treehouse.gainers.R
import com.treehouse.gainers.model.ArrResponse

class StocksAdapter : RecyclerView.Adapter<StocksAdapter.RanViewHolder>() {


    private val data = arrayListOf<ArrResponse>()
    fun setData(data: List<ArrResponse>) {

        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RanViewHolder {
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.item_activity, parent, false)
        return RanViewHolder(rootView) }

    override fun getItemCount(): Int { return data.size }

    override fun onBindViewHolder(viewHolder: RanViewHolder, position: Int)
    { viewHolder.bind(data[position]) }
    class RanViewHolder(private val rootView: View) : RecyclerView.ViewHolder(rootView) {

        fun bind(data: ArrResponse) {

            val tvSymbol =rootView.findViewById<TextView>(R.id.tvSymbol)
            tvSymbol.text= data.symbol




        }
    }
}