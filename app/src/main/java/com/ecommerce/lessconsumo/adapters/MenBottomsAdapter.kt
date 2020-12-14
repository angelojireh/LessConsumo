package com.ecommerce.lessconsumo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ecommerce.lessconsumo.R

class MenBottomsAdapter(val menBottoms: ArrayList<String>) : RecyclerView.Adapter<MenBottomsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // val testing: TextView = itemView.findViewById(R.id.testing)
        val menBottoms_price: TextView = itemView.findViewById(R.id.newarrival_price)
    }

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): MenBottomsAdapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.layout_new_arrivals, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenBottomsAdapter.ViewHolder, position: Int) {
        //  holder.testing.text = appoint[position]
        holder.menBottoms_price.text = menBottoms[position]
    }

    override fun getItemCount() = menBottoms.size
}