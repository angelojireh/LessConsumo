package com.ecommerce.lessconsumo.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.ecommerce.lessconsumo.R
import com.ecommerce.lessconsumo.adapters.BagsAdapter
import com.ecommerce.lessconsumo.adapters.ShoesAdapter
import kotlinx.android.synthetic.main.activity_bags.*
import kotlinx.android.synthetic.main.activity_shoes.*

class ShoesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shoes)

        onClicks()
        setupShoesProducts()

    }

    private fun onClicks() {
        buttonBackShoes.setOnClickListener {
            finishMe()
        }
    }

    private fun finishMe()
    {
        this.finish()
    }

    @SuppressLint("WrongConstant")
    private fun setupShoesProducts() {
        val shoes: ArrayList<String> = ArrayList()

        for (i in 1..30) {
            shoes.add("Php $i")
        }

        recyclerView_shoes.layoutManager = GridLayoutManager(this, 2)
        recyclerView_shoes.adapter = ShoesAdapter(shoes)
    }
}