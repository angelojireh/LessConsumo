package com.ecommerce.lessconsumo.activity

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.ecommerce.lessconsumo.R
import com.ecommerce.lessconsumo.adapters.CartAdapter
import kotlinx.android.synthetic.main.activity_cart.*

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        /*
        elements needed:
            buttonBackCart
            edittext_notes
            textview_subtotal_price
            buttonCheckout
        */

        buttonBackCart.setOnClickListener {
            this.finish()
        }
        buttonCheckout.setOnClickListener {
            gotoNewActivity(InformationActivity())
        }

        setupCartItems()
    }

    private fun gotoNewActivity(activity : Activity) {
        val intent = Intent (this, activity::class.java)
        startActivity(intent)
    }

    @SuppressLint("WrongConstant")
    private fun setupCartItems() {
        val cartItems: ArrayList<String> = ArrayList()

        for (i in 1..5) {
            cartItems.add("$i")
        }

        recyclerView_cart.layoutManager = LinearLayoutManager(this, OrientationHelper.VERTICAL, false)
        recyclerView_cart.adapter = CartAdapter(cartItems)
    }
}