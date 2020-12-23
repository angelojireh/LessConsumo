package com.ecommerce.lessconsumo.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ecommerce.lessconsumo.R
import com.ecommerce.lessconsumo.customclass.ProductDetails
import com.example.lesscon.home.data.ProductModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_new_arrivals.view.*
import kotlinx.android.synthetic.main.layout_new_arrivals.view.iv_image
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class NewProductsAdapter(val context: Activity): RecyclerView.Adapter<NewProductsAdapter.NewProductsViewHolder>() {

    private var data: MutableList<ProductModel>? = ArrayList()
    fun setData(list: ArrayList<ProductModel>)
    {
        data?.addAll(list)
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
                val mProductDetails = data?.let { ProductDetails(context, position, it as ArrayList<ProductModel>) }
                mProductDetails?.showProductData()
            }
        }

        fun bindView(item: ProductModel?)
        {
            val mNumberFormat: NumberFormat = NumberFormat.getCurrencyInstance()
            mNumberFormat.maximumFractionDigits = 2
            mNumberFormat.currency = Currency.getInstance("PHP")

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
                loadPicassoImage(image_src, itemView.iv_image)
            }
            else
            {
                val no_image = "https://www.freeiconspng.com/thumbs/no-image-icon/no-image-icon-6.png"
                loadPicassoImage(no_image, itemView.iv_image)
            }
        }

        fun loadPicassoImage(image: String, imageView: ImageView)
        {
            Picasso.get()
                    .load(image)
                    .resize(450,450)
                    .centerCrop()
                    .into(imageView)
        }
    }

}