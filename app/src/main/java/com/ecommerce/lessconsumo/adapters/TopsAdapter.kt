package com.ecommerce.lessconsumo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ecommerce.lessconsumo.R

class TopsAdapter(val tops: ArrayList<String>) : RecyclerView.Adapter<TopsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // val testing: TextView = itemView.findViewById(R.id.testing)
        val tops_price: TextView = itemView.findViewById(R.id.newarrival_price)
    }

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): TopsAdapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.layout_new_arrivals, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopsAdapter.ViewHolder, position: Int) {
        //  holder.testing.text = appoint[position]
        holder.tops_price.text = tops[position]
    }

    override fun getItemCount() = tops.size
}