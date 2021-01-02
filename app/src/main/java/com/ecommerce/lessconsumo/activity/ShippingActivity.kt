package com.ecommerce.lessconsumo.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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
            R.id.buttonContinueToPayment ->
                if (rg_shipping.checkedRadioButtonId != -1)
                {
                    showToast("You chose ${rb_delivery.text}")
                    gotoNewActivity(PaymentActivity())
                } else showToast("Please select a shipping method")
        }
    }

    private fun initOnClickListeners() {
        buttonBackShipping.setOnClickListener(this)
        buttonContinueToPayment.setOnClickListener(this)
    }

    private fun showToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

    private fun gotoNewActivity(activity : Activity) {
        val intent = Intent (this, activity::class.java)
        startActivity(intent)
    }

    private fun finishMe() {
        this.finish()
    }
}