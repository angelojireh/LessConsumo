package com.ecommerce.lessconsumo.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.ecommerce.lessconsumo.R
import com.ecommerce.lessconsumo.adapters.BoysAdapter
import com.ecommerce.lessconsumo.adapters.MenBottomsAdapter
import kotlinx.android.synthetic.main.activity_boys.*
import kotlinx.android.synthetic.main.activity_men_bottoms.*

class BoysActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boys)

        onClicks()
        setupBoysProducts()

    }

    private fun onClicks() {
        buttonBackBoys.setOnClickListener {
            finishMe()
        }
    }

    private fun finishMe()
    {
        this.finish()
    }

    @SuppressLint("WrongConstant")
    private fun setupBoysProducts() {
        val boys: ArrayList<String> = ArrayList()

        for (i in 1..30) {
            boys.add("Php $i")
        }

        recyclerView_boys.layoutManager = GridLayoutManager(this, 2)
        recyclerView_boys.adapter = BoysAdapter(boys)
    }
}