package com.ecommerce.lessconsumo.data

import android.app.Activity
import android.content.Intent
import android.text.Html
import com.ecommerce.lessconsumo.activity.ProductActivity
import com.example.lesscon.home.data.GetModel
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class ProductModel(val context: Activity, val position: Int, var data: ArrayList<GetModel> ) {
    fun showProductData()
    {
        val NO_IMAGE_URL = "https://www.freeiconspng.com/thumbs/no-image-icon/no-image-icon-6.png"
        val productName = data[position].name
        val productSKU = data[position].sku
        val productStock = data[position].stock_quantity
        val productDescription = Html.fromHtml(data[position].short_description)
        val productImage = if((data[position].images).isNotEmpty())
            data[position].images[0].src else NO_IMAGE_URL
        val size = ((productDescription.toString()).substringAfter("Size:")).substringBefore(',')
        var regularPrice = data[position].regular_price
        var salePrice = data[position].sale_price
        var categories = ""

        if((regularPrice).isNotEmpty())
            regularPrice = currencyFormatter(regularPrice.toDouble()) else ""
        if((salePrice).isNotEmpty())
            salePrice = currencyFormatter(salePrice.toDouble()) else ""
        for(c in data[position].categories)
            categories += c.slug.plus(", ")

        gotoProductActivity(context, productName, productSKU, productStock.toString(), productDescription.toString(), productImage, size, regularPrice, salePrice, categories)
    }

    fun currencyFormatter(mNumber: Double): String
    {
        val mNumberFormat: NumberFormat = NumberFormat.getCurrencyInstance()
        mNumberFormat.maximumFractionDigits = 2
        mNumberFormat.currency = Currency.getInstance("PHP")
        return (mNumberFormat.format(mNumber)).toString()
    }

    fun gotoProductActivity(
            context: Activity,
            productName: String,
            productSKU: String,
            productStock: String,
            productDescription: String,
            productImage: String,
            size: String,
            regularPrice: String,
            salePrice: String,
            categories: String)
    {
        val i = Intent(context, ProductActivity::class.java)
        i.putExtra("productImage", productImage)
        i.putExtra("productName", productName)
        i.putExtra("regularPrice", regularPrice)
        i.putExtra("salePrice", salePrice)
        i.putExtra("sku", productSKU)
        i.putExtra("stock", productStock)
        i.putExtra("shortDescription", productDescription)
        i.putExtra("size", size)
        i.putExtra("categories", categories)
        context.startActivity(i)
    }
}