package com.ecommerce.lessconsumo.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ecommerce.lessconsumo.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity(), View.OnClickListener {

    private var productImage: String? = null
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

        initOnClickListeners()
        loadProduct()
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.buttonBackProduct -> finishMe()
            R.id.buttonAddToBag -> addToBag()
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
        productName = intent.getStringExtra("productName")
        regularPrice = intent.getStringExtra("regularPrice")
        salePrice = intent.getStringExtra("salePrice")
        sku = intent.getStringExtra("sku")
        stock = intent.getStringExtra("stock")
        shortDescription = intent.getStringExtra("shortDescription")
        size = intent.getStringExtra("size")
        categories = intent.getStringExtra("categories")

        Picasso.get().load(productImage).into(iv_productImage)
        tv_productName.text = productName
        tv_regularPrice.text = regularPrice
        tv_salePrice.text = salePrice
        tv_sku.text = sku
        tv_stock.text = stock
        tv_description.text = shortDescription
        tv_size.text = size
        tv_categories.text = categories
    }

    private fun addToBag()
    {
        // add to bag functionality
    }
}