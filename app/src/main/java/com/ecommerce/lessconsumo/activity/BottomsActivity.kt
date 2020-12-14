package com.ecommerce.lessconsumo.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.ecommerce.lessconsumo.R
import com.ecommerce.lessconsumo.adapters.BottomsAdapter
import com.ecommerce.lessconsumo.adapters.TopsAdapter
import kotlinx.android.synthetic.main.activity_bottoms.*
import kotlinx.android.synthetic.main.activity_tops.*

class BottomsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottoms)

        onClicks()
        setupBottomsProducts()

    }

    private fun onClicks() {
        buttonBackBottoms.setOnClickListener {
            finishMe()
        }
    }

    private fun finishMe()
    {
        this.finish()
    }

    @SuppressLint("WrongConstant")
    private fun setupBottomsProducts() {
        val bottoms: ArrayList<String> = ArrayList()

        for (i in 1..30) {
            bottoms.add("Php $i")
        }

        recyclerView_bottoms.layoutManager = GridLayoutManager(this, 2)
        recyclerView_bottoms.adapter = BottomsAdapter(bottoms)
    }
}