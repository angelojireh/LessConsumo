package com.ecommerce.lessconsumo.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.ecommerce.lessconsumo.R
import com.ecommerce.lessconsumo.adapters.BagsAdapter
import com.ecommerce.lessconsumo.adapters.DressesAdapter
import kotlinx.android.synthetic.main.activity_bags.*
import kotlinx.android.synthetic.main.activity_dresses.*

class BagsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bags)

        onClicks()
        setupBagsProducts()

    }

    private fun onClicks() {
        buttonBackBags.setOnClickListener {
            finishMe()
        }
    }

    private fun finishMe()
    {
        this.finish()
    }

    @SuppressLint("WrongConstant")
    private fun setupBagsProducts() {
        val bags: ArrayList<String> = ArrayList()

        for (i in 1..30) {
            bags.add("Php $i")
        }

        recyclerView_bags.layoutManager = GridLayoutManager(this, 2)
        recyclerView_bags.adapter = BagsAdapter(bags)
    }
}