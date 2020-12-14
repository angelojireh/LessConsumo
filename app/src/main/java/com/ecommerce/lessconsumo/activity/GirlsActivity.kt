package com.ecommerce.lessconsumo.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.ecommerce.lessconsumo.R
import com.ecommerce.lessconsumo.adapters.GirlsAdapter
import kotlinx.android.synthetic.main.activity_boys.*
import kotlinx.android.synthetic.main.activity_boys.buttonBackBoys
import kotlinx.android.synthetic.main.activity_girls.*

class GirlsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_girls)

        onClicks()
        setupGirlsProducts()

    }

    private fun onClicks() {
        buttonBackGirls.setOnClickListener {
            finishMe()
        }
    }

    private fun finishMe()
    {
        this.finish()
    }

    @SuppressLint("WrongConstant")
    private fun setupGirlsProducts() {
        val girls: ArrayList<String> = ArrayList()

        for (i in 1..30) {
            girls.add("Php $i")
        }

        recyclerView_girls.layoutManager = GridLayoutManager(this, 2)
        recyclerView_girls.adapter = GirlsAdapter(girls)
    }
}