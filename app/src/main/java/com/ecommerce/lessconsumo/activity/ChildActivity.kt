package com.ecommerce.lessconsumo.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ecommerce.lessconsumo.R
import kotlinx.android.synthetic.main.activity_child.*

class ChildActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_child)

        buttonBackChild.setOnClickListener {
            gotoNewActivity(HomeActivity())
        }
        buttonCartChild.setOnClickListener {
            gotoNewActivity(CartActivity())
        }
        textviewSale_child.setOnClickListener {
            gotoNewActivity(SaleActivity())
        }
        textviewMen_child.setOnClickListener {
            gotoNewActivity(MenActivity())
        }
        textviewWomen_child.setOnClickListener {
            gotoNewActivity(WomenActivity())
        }
    }

    private fun gotoNewActivity(activity : Activity) {
        val intent = Intent (this, activity::class.java)
        startActivity(intent)
    }
}