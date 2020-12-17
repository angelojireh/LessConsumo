package com.ecommerce.lessconsumo.adapters

import android.app.Activity
import android.content.Intent
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ecommerce.lessconsumo.R
import com.ecommerce.lessconsumo.activity.ProductActivity
import com.ecommerce.lessconsumo.data.ProductModel
import com.example.lesscon.home.data.GetModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_new_arrivals.view.*
import kotlinx.android.synthetic.main.layout_new_arrivals.view.iv_image
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class NewProductsAdapter(val context: Activity): RecyclerView.Adapter<NewProductsAdapter.NewProductsViewHolder>() {

    private var data: ArrayList<GetModel>? = null
    fun setData(list: ArrayList<GetModel>)
    {
        data = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewProductsViewHolder {
        return NewProductsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_new_arrivals, parent, false))
    }

    override fun onBindViewHolder(holder: NewProductsViewHolder, position: Int) {
        val item = data?.get(position)
        holder.bindView(item)
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    inner class NewProductsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener
    {
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = bindingAdapterPosition
            if(position != RecyclerView.NO_POSITION) {
                val mProductModel = data?.let { ProductModel(context, position, it) }
                mProductModel?.showProductData()
            }
        }

        fun bindView(item: GetModel?)
        {
            val mNumberFormat: NumberFormat = NumberFormat.getCurrencyInstance()
            mNumberFormat.maximumFractionDigits = 2
            mNumberFormat.currency = Currency.getInstance("PHP")

            val no_image = "https://www.freeiconspng.com/thumbs/no-image-icon/no-image-icon-6.png"
            val price: String?

            if(item?.price != null && item.price.isNotEmpty())
            {
                price = mNumberFormat.format(item.price.toDouble())
                itemView.newarrival_price.text = price
            }
            else
            {
                itemView.newarrival_price.text = "N/A"
            }

            if(item?.images != null && item.images.isNotEmpty())
            {
                val image_src = item.images[0].src
                Picasso.get().load(image_src).into(itemView.iv_image)
            }
            else
            {
                Picasso.get().load(no_image).into(itemView.iv_image)
            }
        }

    }

}