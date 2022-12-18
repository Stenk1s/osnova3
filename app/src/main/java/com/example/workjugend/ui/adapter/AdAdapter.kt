package com.example.workjugend.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.workjugend.R
import com.example.workjugend.ui.models.Ad

class AdAdapter(private val AdDataSet: List<Ad>, private val clickListener: (String) -> Unit) : RecyclerView.Adapter<AdAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ad_name = view.findViewById<TextView>(R.id.ad_name)
        val ad_pg = view.findViewById<TextView>(R.id.ad_pg)
        val ad_sity = view.findViewById<TextView>(R.id.ad_sity)
        val ad_zarplata = view.findViewById<TextView>(R.id.ad_zarplata)
        val ad_namber = view.findViewById<TextView>(R.id.ad_namber)
        val button = view.findViewById<Button>(R.id.v_obavlen)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ad, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.ad_name.text =AdDataSet[position].Title
        holder.ad_namber.text =AdDataSet[position].Namber
        holder.ad_pg.text = holder.itemView.context.getString(R.string.pg, AdDataSet[position].Organization)
        holder.ad_sity.text = holder.itemView.context.getString(R.string.ad_sity, AdDataSet[position].Sity)
        holder.ad_zarplata.text = holder.itemView.context.getString(R.string.ad_zarplata, AdDataSet[position].Zarplata)
        holder.button.setOnClickListener { clickListener(AdDataSet[position].Id.toString()) }
    }

    override fun getItemCount(): Int {
        return AdDataSet.size
    }
}