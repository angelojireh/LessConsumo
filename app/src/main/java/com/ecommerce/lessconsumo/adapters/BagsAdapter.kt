package com.ecommerce.lessconsumo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ecommerce.lessconsumo.R

class BagsAdapter(val bags: ArrayList<String>) : RecyclerView.Adapter<BagsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // val testing: TextView = itemView.findViewById(R.id.testing)
        val bags_price: TextView = itemView.findViewById(R.id.newarrival_price)
    }

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): BagsAdapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.layout_new_arrivals, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: BagsAdapter.ViewHolder, position: Int) {
        //  holder.testing.text = appoint[position]
        holder.bags_price.text = bags[position]
    }

    override fun getItemCount() = bags.size
}