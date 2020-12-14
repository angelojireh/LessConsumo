package com.ecommerce.lessconsumo.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.ecommerce.lessconsumo.R
import com.ecommerce.lessconsumo.adapters.TopsAdapter
import kotlinx.android.synthetic.main.activity_tops.*

class TopsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tops)

        onClicks()
        setupTopsProducts()

    }

    private fun onClicks() {
        buttonBackTops.setOnClickListener {
            finishMe()
        }
    }

    private fun finishMe()
    {
        this.finish()
    }

    @SuppressLint("WrongConstant")
    private fun setupTopsProducts() {
        val tops: ArrayList<String> = ArrayList()

        for (i in 1..30) {
            tops.add("Php $i")
        }

        recyclerView_tops.layoutManager = GridLayoutManager(this, 2)
        recyclerView_tops.adapter = TopsAdapter(tops)
    }
}