package com.ecommerce.lessconsumo.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.ecommerce.lessconsumo.R
import com.ecommerce.lessconsumo.adapters.BottomsAdapter
import com.ecommerce.lessconsumo.adapters.DressesAdapter
import kotlinx.android.synthetic.main.activity_bottoms.*
import kotlinx.android.synthetic.main.activity_dresses.*

class DressesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dresses)

        onClicks()
        setupDressesProducts()

    }

    private fun onClicks() {
        buttonBackDresses.setOnClickListener {
            finishMe()
        }
    }

    private fun finishMe()
    {
        this.finish()
    }

    @SuppressLint("WrongConstant")
    private fun setupDressesProducts() {
        val dress: ArrayList<String> = ArrayList()

        for (i in 1..30) {
            dress.add("Php $i")
        }

        recyclerView_dresses.layoutManager = GridLayoutManager(this, 2)
        recyclerView_dresses.adapter = DressesAdapter(dress)
    }
}