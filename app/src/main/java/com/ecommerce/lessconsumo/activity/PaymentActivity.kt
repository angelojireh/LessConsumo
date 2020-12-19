package com.ecommerce.lessconsumo.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import com.ecommerce.lessconsumo.R
import kotlinx.android.synthetic.main.activity_payment.*
import kotlinx.android.synthetic.main.activity_shipping.*

class PaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        // added
        buttonComplete.setOnClickListener {
            var id: Int = rg_payment.checkedRadioButtonId
            if (id != -1) {
                // val radio:RadioButton = findViewById(id)
                Toast.makeText(this, "Your order has been placed", Toast.LENGTH_SHORT).show()
                gotoNewActivity(HomeActivity())
            }
            else {
                Toast.makeText(this, "Choose payment method.", Toast.LENGTH_SHORT).show()
            }
        }
        buttonBackPayment.setOnClickListener {
            this.finish()
        }
    }

    fun radio_button_click(view: View){
        val radio: RadioButton = findViewById(rg_payment.checkedRadioButtonId)
        val payment_method = radio.text

        if (payment_method == "Online Payment") {
            textview_paymentoptions.visibility = View.VISIBLE
        }
        else {
            textview_paymentoptions.visibility = View.GONE
        }
    }

    private fun gotoNewActivity(activity : Activity) {
        val intent = Intent (this, activity::class.java)
        startActivity(intent)
    }
}