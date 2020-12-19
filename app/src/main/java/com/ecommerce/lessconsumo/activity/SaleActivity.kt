package com.ecommerce.lessconsumo.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ecommerce.lessconsumo.R
import kotlinx.android.synthetic.main.activity_sale.*

class SaleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sale)

        buttonBackSale.setOnClickListener {
            gotoNewActivity(HomeActivity())
        }
        buttonCartSale.setOnClickListener {
            gotoNewActivity(CartActivity())
        }
        textviewMen_sale.setOnClickListener {
            gotoNewActivity(MenActivity())
        }
        textviewWomen_sale.setOnClickListener {
            gotoNewActivity(WomenActivity())
        }
        textviewChild_sale.setOnClickListener {
            gotoNewActivity(ChildActivity())
        }
    }

    private fun gotoNewActivity(activity : Activity) {
        val intent = Intent (this, activity::class.java)
        startActivity(intent)
    }
}