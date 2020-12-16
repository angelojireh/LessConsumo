package com.ecommerce.lessconsumo.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ecommerce.lessconsumo.R
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        initOnClickListeners()

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

    private fun addToBag()
    {
        // add to bag functionality
    }
}