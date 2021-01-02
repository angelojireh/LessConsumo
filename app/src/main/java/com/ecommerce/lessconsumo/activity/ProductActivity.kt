package com.ecommerce.lessconsumo.activity


import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ecommerce.lessconsumo.R
import com.ecommerce.lessconsumo.data.ShoppingCartRepository
import com.ecommerce.lessconsumo.data.CartItemModel
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import io.paperdb.Paper
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity(), View.OnClickListener {

    private var productImage: String? = null
    private var productID: Int? = null
    private var productName: String? = null
    private var regularPrice: String? = null
    private var salePrice: String? = null
    private var sku: String? = null
    private var stock: String? = null
    private var shortDescription: String? = null
    private var size: String? = null
    private var categories: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        //PaperDB initialization
        Paper.init(applicationContext)
        initOnClickListeners()
        loadProduct()
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.buttonBackProduct -> finishMe()
            R.id.buttonAddToBag -> {
                addToBag()
                Snackbar.make(v, "${productName} was added to your cart", Snackbar.LENGTH_SHORT).show()
                Log.i("paperDB", ShoppingCartRepository.getCart().toString())
            }
        }
    }

    private fun initOnClickListeners() {
        buttonBackProduct.setOnClickListener(this)
        buttonAddToBag.setOnClickListener(this)
    }

    private fun finishMe()
    {
        this.finish()
    }

    private fun loadProduct()
    {
        productImage = intent.getStringExtra("productImage")
        productID = intent.getIntExtra("productID", 0)
        productName = intent.getStringExtra("productName")
        regularPrice = intent.getStringExtra("regularPrice")
        salePrice = intent.getStringExtra("salePrice")
        sku = intent.getStringExtra("sku")
        stock = intent.getStringExtra("stock")
        shortDescription = intent.getStringExtra("shortDescription")
        size = intent.getStringExtra("size")
        categories = intent.getStringExtra("categories")

        Picasso.get()
                .load(productImage)
                .resize(650,650)
                .centerCrop()
                .into(iv_productImage)
        tv_productName.text = productName
        tv_sku.text = sku
        tv_stock.text = stock
        tv_description.text = shortDescription
        tv_size.text = size
        tv_categories.text = categories

        if(regularPrice.isNullOrEmpty()) tv_regularPrice.visibility = View.GONE
        else {
            tv_regularPrice.text = regularPrice
            tv_regularPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        }

        if((salePrice.isNullOrEmpty())) {
            tv_regularPrice.visibility = View.GONE
            tv_salePrice.text = regularPrice
        } else tv_salePrice.text = salePrice

    }

    private fun addToBag()
    {
        val item = CartItemModel(productID!!.toInt(), 1, productName!!.toString(), productImage!!.toString(), tv_salePrice.text.toString())
        ShoppingCartRepository.addItem(item)
    }
}