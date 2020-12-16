package com.ecommerce.lessconsumo.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ecommerce.lessconsumo.R
import kotlinx.android.synthetic.main.activity_shipping.*

class ShippingActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shipping)

        initOnClickListeners()
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.buttonBackShipping -> finishMe()
            R.id.buttonContinue -> gotoNewActivity(PaymentActivity())
        }
    }

    private fun initOnClickListeners()
    {
        buttonBackShipping.setOnClickListener(this)
        buttonContinue.setOnClickListener(this)
    }

    private fun gotoNewActivity(activity : Activity) {
        val intent = Intent (this, activity::class.java)
        startActivity(intent)
    }

    private fun finishMe()
    {
        this.finish()
    }
}