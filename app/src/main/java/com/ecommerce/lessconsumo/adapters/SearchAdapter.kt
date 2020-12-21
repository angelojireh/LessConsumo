package com.ecommerce.lessconsumo.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ecommerce.lessconsumo.R
import com.ecommerce.lessconsumo.customclass.ProductDetails
import com.example.lesscon.home.data.ProductModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_category_recyclerview.view.*
import kotlinx.android.synthetic.main.layout_category_recyclerview.view.iv_image
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class SearchAdapter(val context: Activity): RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    private var data: ArrayList<ProductModel>? = null
    fun setData(list: ArrayList<ProductModel>)
    {
        data = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_category_recyclerview, parent, false))
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val item = data?.get(position)
        holder.bindView(item)
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    inner class SearchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener
    {
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = bindingAdapterPosition
            if(position != RecyclerView.NO_POSITION) {
                val mProductDetails = data?.let { ProductDetails(context, position, it) }
                mProductDetails?.showProductData()
            }
        }

        fun bindView(item: ProductModel?)
        {
            val mNumberFormat: NumberFormat = NumberFormat.getCurrencyInstance()
            mNumberFormat.maximumFractionDigits = 2
            mNumberFormat.currency = Currency.getInstance("PHP")

            val no_image = "https://www.freeiconspng.com/thumbs/no-image-icon/no-image-icon-6.png"
            val price: String?

            //name
            itemView.item_name.text = item?.name

            //price
            if(item?.price != null && item.price.isNotEmpty())
            {
                price = mNumberFormat.format(item.price.toDouble())
                itemView.sale_price.text = price
            }
            else
            {
                itemView.sale_price.text = "N/A"
            }

            //image
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