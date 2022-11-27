package com.example.sportlandapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.sportlandapp.R
import com.example.sportlandapp.ui.models.Ad

class AdAdapter(private val AdDataSet: List<Ad>) : RecyclerView.Adapter<AdAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ad_name = view.findViewById<TextView>(R.id.ad_name)
        val ad_pg = view.findViewById<TextView>(R.id.ad_pg)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ad, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.ad_name.text = holder.itemView.context.getString(R.string.nazv, AdDataSet[position].Title)
        holder.ad_pg.text = holder.itemView.context.getString(R.string.pg, AdDataSet[position].Organization)
    }

    override fun getItemCount(): Int {
        return AdDataSet.size
    }
}