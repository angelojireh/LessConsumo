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
import kotlinx.android.synthetic.main.activity_payment.view.*
import kotlinx.android.synthetic.main.activity_shipping.*

class PaymentActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        initOnClickListener()
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.buttonComplete ->
                if(rg_payment.checkedRadioButtonId != -1)
                {
                    showToast("Your order has been placed")
                    gotoNewActivity(HomeActivity())
                } else showToast("Please select a payment method")
        }
    }

    fun onRadioButtonClicked(view: View){
        if(view is RadioButton)
        {
            val isChecked = view.isChecked
            when(view.id)
            {
                R.id.rb_onlinepayment -> if(isChecked) textview_paymentoptions.visibility = View.VISIBLE
                    else textview_paymentoptions.visibility = View.GONE
            }
        }
        buttonBackPayment.setOnClickListener {
            this.finish()
        }
    }

    private fun initOnClickListener()
    {
        buttonComplete.setOnClickListener(this)
    }

    private fun showToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

    private fun gotoNewActivity(activity : Activity) {
        val intent = Intent (this, activity::class.java)
        startActivity(intent)
    }
}