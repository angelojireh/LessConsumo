package com.ecommerce.lessconsumo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ecommerce.lessconsumo.R
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        buttonBackSearch.setOnClickListener {
            this.finish()
        }
        buttonSearchLC.setOnClickListener {
            // go to new activity, show items
        }
    }
}