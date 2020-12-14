package com.ecommerce.lessconsumo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ecommerce.lessconsumo.R

class MenTopsAdapter(val menTops: ArrayList<String>) : RecyclerView.Adapter<MenTopsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // val testing: TextView = itemView.findViewById(R.id.testing)
        val menTops_price: TextView = itemView.findViewById(R.id.newarrival_price)
    }

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): MenTopsAdapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.layout_new_arrivals, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenTopsAdapter.ViewHolder, position: Int) {
        //  holder.testing.text = appoint[position]
        holder.menTops_price.text = menTops[position]
    }

    override fun getItemCount() = menTops.size
}