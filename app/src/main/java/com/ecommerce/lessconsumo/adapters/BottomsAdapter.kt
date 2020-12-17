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
import com.example.lesscon.home.data.GetModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_category_recyclerview.view.*
import kotlinx.android.synthetic.main.layout_category_recyclerview.view.iv_image
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class BottomsAdapter(val context: Activity): RecyclerView.Adapter<BottomsAdapter.BottomsViewHolder>() {

    private var data: ArrayList<GetModel>? = null
    fun setData(list: ArrayList<GetModel>)
    {
        data = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomsViewHolder {
        return BottomsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_category_recyclerview, parent, false))
    }

    override fun onBindViewHolder(holder: BottomsViewHolder, position: Int) {
        val item = data?.get(position)
        holder.bindView(item)
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    inner class BottomsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener
    {
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = bindingAdapterPosition
            if(position != RecyclerView.NO_POSITION) {

                val mNumberFormat: NumberFormat = NumberFormat.getCurrencyInstance()
                mNumberFormat.maximumFractionDigits = 2
                mNumberFormat.currency = Currency.getInstance("PHP")

                val noImage = "https://www.freeiconspng.com/thumbs/no-image-icon/no-image-icon-6.png"
                val productName = data?.get(position)?.name
                var regularPrice = data?.get(position)?.regular_price
                regularPrice = if(!regularPrice.isNullOrEmpty()) mNumberFormat.format(regularPrice?.toDouble()) else "N/A"
                var salePrice = data?.get(position)?.sale_price
                salePrice = if(!salePrice.isNullOrEmpty()) mNumberFormat.format(salePrice?.toDouble()) else "N/A"
                val sku = data?.get(position)?.sku
                val stock = data?.get(position)?.stock_quantity
                val shortDescription = (Html.fromHtml(data?.get(position)?.short_description)).toString()

                val productImage = if(!(data?.get(position)?.images).isNullOrEmpty())
                    data?.get(position)?.images?.get(0)?.src else noImage

                var size = shortDescription.substringAfter("Size:")
                size = size.substringBefore(',')

                var categories = ""
                for (categ in data?.get(position)?.categories!!)
                {
                    categories += categ.slug.plus(", ")
                }

                val i = Intent(context, ProductActivity::class.java)
                i.putExtra("productImage", productImage.toString())
                i.putExtra("productName", productName.toString())
                i.putExtra("regularPrice", regularPrice.toString())
                i.putExtra("salePrice", salePrice.toString())
                i.putExtra("sku", sku.toString())
                i.putExtra("stock", stock.toString())
                i.putExtra("shortDescription", shortDescription)
                i.putExtra("size", size)
                i.putExtra("categories", categories)
                context.startActivity(i)
            }
        }

        fun bindView(item: GetModel?)
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