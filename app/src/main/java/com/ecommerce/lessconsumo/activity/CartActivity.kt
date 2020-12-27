package com.ecommerce.lessconsumo.activity

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.ecommerce.lessconsumo.R
import com.ecommerce.lessconsumo.adapters.CartAdapter
import com.ecommerce.lessconsumo.customclass.ShoppingCart
import io.paperdb.Paper
import kotlinx.android.synthetic.main.activity_cart.*

class CartActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mCartAdapter: CartAdapter
    private lateinit var mLinearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        Paper.init(applicationContext)
        initButtonClickListener()
        initCartAdapter()
    }

    private fun gotoNewActivity(activity : Activity) {
        val intent = Intent (this, activity::class.java)
        startActivity(intent)
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.buttonBackCart -> this.finish()
            R.id.buttonCheckout -> gotoNewActivity(InformationActivity())
        }
    }

    private fun initButtonClickListener() {
        buttonBackCart.setOnClickListener(this)
        buttonCheckout.setOnClickListener(this)
    }

    private fun initCartAdapter() {
        mLinearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mCartAdapter = CartAdapter(this, ShoppingCart.getCart())
        //mCartAdapter.notifyDataSetChanged()
        recyclerView_cart.setHasFixedSize(true)
        recyclerView_cart.layoutManager = mLinearLayoutManager
        recyclerView_cart.adapter = mCartAdapter
    }
}