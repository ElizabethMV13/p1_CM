package com.example.p1_cm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val listIng:List<Engineering>) : RecyclerView.Adapter<EngineeringViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EngineeringViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return EngineeringViewHolder(layoutInflater.inflate(R.layout.item_ingenieria,parent, false))
    }

    override fun getItemCount(): Int = listIng.size

    override fun onBindViewHolder(holder: EngineeringViewHolder, position: Int) {
        val item = listIng[position]
        holder.render(item)
    }
}