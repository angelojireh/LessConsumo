package com.ecommerce.lessconsumo.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.ecommerce.lessconsumo.R
import com.ecommerce.lessconsumo.adapters.MenTopsAdapter
import com.ecommerce.lessconsumo.adapters.ShoesAdapter
import kotlinx.android.synthetic.main.activity_men_tops.*
import kotlinx.android.synthetic.main.activity_shoes.*

class MenTopsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_men_tops)

        onClicks()
        setupMenTopsProducts()

    }

    private fun onClicks() {
        buttonBackMenTops.setOnClickListener {
            finishMe()
        }
    }

    private fun finishMe()
    {
        this.finish()
    }

    @SuppressLint("WrongConstant")
    private fun setupMenTopsProducts() {
        val menTops: ArrayList<String> = ArrayList()

        for (i in 1..30) {
            menTops.add("Php $i")
        }

        recyclerView_menTops.layoutManager = GridLayoutManager(this, 2)
        recyclerView_menTops.adapter = MenTopsAdapter(menTops)
    }
}