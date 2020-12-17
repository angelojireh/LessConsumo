package com.ecommerce.lessconsumo.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.ecommerce.lessconsumo.R
import kotlinx.android.synthetic.main.activity_shipping.*

class ShippingActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shipping)

        // added
        buttonContinueToPayment.setOnClickListener {
            var id: Int = rg_shipping.checkedRadioButtonId
            if (id != -1) {
                // val radio:RadioButton = findViewById(id)
                Toast.makeText(this, "You chose delivery.", Toast.LENGTH_SHORT).show()
                gotoNewActivity(PaymentActivity())
            }
            else {
                Toast.makeText(this, "Choose shipping method.", Toast.LENGTH_SHORT).show()
            }
        }

        initOnClickListeners()

    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.buttonBackShipping -> finishMe()
            // R.id.buttonContinueToPayment -> gotoNewActivity(PaymentActivity())
        }
    }

    private fun initOnClickListeners()
    {
        buttonBackShipping.setOnClickListener(this)
        // buttonContinueToPayment.setOnClickListener(this)
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