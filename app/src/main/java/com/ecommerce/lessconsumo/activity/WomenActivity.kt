package com.ecommerce.lessconsumo.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ecommerce.lessconsumo.R
import kotlinx.android.synthetic.main.activity_sale.*
import kotlinx.android.synthetic.main.activity_women.*

class WomenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_women)

        buttonBackWomen.setOnClickListener {
            gotoNewActivity(HomeActivity())
        }
        buttonCartWomen.setOnClickListener {
            gotoNewActivity(CartActivity())
        }
        textviewSale_women.setOnClickListener {
            gotoNewActivity(SaleActivity())
        }
        textviewMen_women.setOnClickListener {
            gotoNewActivity(MenActivity())
        }
        textviewChild_women.setOnClickListener {
            gotoNewActivity(ChildActivity())
        }
    }

    private fun gotoNewActivity(activity : Activity) {
        val intent = Intent (this, activity::class.java)
        startActivity(intent)
    }
}