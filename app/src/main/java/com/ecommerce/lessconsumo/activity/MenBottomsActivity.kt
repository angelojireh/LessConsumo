package com.ecommerce.lessconsumo.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.ecommerce.lessconsumo.R
import com.ecommerce.lessconsumo.adapters.MenBottomsAdapter
import com.ecommerce.lessconsumo.adapters.MenTopsAdapter
import kotlinx.android.synthetic.main.activity_men_bottoms.*
import kotlinx.android.synthetic.main.activity_men_tops.*

class MenBottomsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_men_bottoms)

        onClicks()
        setupMenBottomsProducts()

    }

    private fun onClicks() {
        buttonBackMenBottoms.setOnClickListener {
            finishMe()
        }
    }

    private fun finishMe()
    {
        this.finish()
    }

    @SuppressLint("WrongConstant")
    private fun setupMenBottomsProducts() {
        val menBottoms: ArrayList<String> = ArrayList()

        for (i in 1..30) {
            menBottoms.add("Php $i")
        }

        recyclerView_menBottoms.layoutManager = GridLayoutManager(this, 2)
        recyclerView_menBottoms.adapter = MenBottomsAdapter(menBottoms)
    }
}