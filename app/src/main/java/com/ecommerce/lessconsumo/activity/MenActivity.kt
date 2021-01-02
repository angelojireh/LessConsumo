package com.ecommerce.lessconsumo.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ecommerce.lessconsumo.R
import kotlinx.android.synthetic.main.activity_men.*

class MenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_men)

        buttonBackMen.setOnClickListener {
            gotoNewActivity(HomeActivity())
        }
        buttonCartMen.setOnClickListener {
            gotoNewActivity(CartActivity())
        }
        textviewSale_men.setOnClickListener {
            gotoNewActivity(SaleActivity())
        }
        textviewWomen_men.setOnClickListener {
            gotoNewActivity(WomenActivity())
        }
        textviewChild_men.setOnClickListener {
            gotoNewActivity(ChildActivity())
        }
    }

    private fun gotoNewActivity(activity : Activity) {
        val intent = Intent (this, activity::class.java)
        startActivity(intent)
    }
}