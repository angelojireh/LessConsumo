package com.ecommerce.lessconsumo.adapters

import android.app.Activity
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ecommerce.lessconsumo.R
import com.ecommerce.lessconsumo.customclass.ProductDetails
import com.example.lesscon.home.data.ProductModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_sale_products.view.*
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class SaleProductsAdapter(val context: Activity): RecyclerView.Adapter<SaleProductsAdapter.SaleProductsViewHolder>() {

    private var data: ArrayList<ProductModel>? = null
    fun setData(list: ArrayList<ProductModel>)
    {
        data = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaleProductsViewHolder {
        return SaleProductsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_sale_products, parent, false))
    }

    override fun onBindViewHolder(holder: SaleProductsViewHolder, position: Int) {
        val item = data?.get(position)
        holder.bindView(item)
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    inner class SaleProductsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener
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
            val no_price = "Price unavailable"
            var regular_price = ""
            var sale_price = ""

            if(!(item?.regular_price).isNullOrEmpty())
            {
                regular_price = mNumberFormat.format(item?.regular_price?.toDouble())
                itemView.regular_price.text = regular_price
                (itemView.regular_price).paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            }
            else itemView.regular_price.visibility = View.GONE

            if(!(item?.sale_price).isNullOrEmpty())
            {
                sale_price = mNumberFormat.format(item?.sale_price?.toDouble())
                itemView.sale_price.text = sale_price
            }
            else itemView.sale_price.text = no_price

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
