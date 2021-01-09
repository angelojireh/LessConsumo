package com.ecommerce.lessconsumo.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.text.InputType
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ecommerce.lessconsumo.R
import com.ecommerce.lessconsumo.data.OrderModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_information.*
import kotlinx.android.synthetic.main.activity_shipping.*
import java.text.NumberFormat
import java.util.*

class ShippingActivity : AppCompatActivity(), View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private lateinit var address_1: String
    private lateinit var city: String
    private lateinit var country: String
    private lateinit var email: String
    private lateinit var first_name: String
    private lateinit var last_name: String
    private lateinit var phone: String
    private lateinit var postcode: String
    private lateinit var state: String
    private var subtotal = 0.00

    private lateinit var shipping_method_id: String
    private lateinit var shipping_method_title: String
    private var shipping_fee = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shipping)

        getExtras()
        setTexts()
        initOnClickListeners()

    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.buttonBackShipping -> this.finish()
            R.id.buttonContinueToPayment -> {
                if(rg_shipping.checkedRadioButtonId != -1){
                    gotoNewActivity(PaymentActivity())
                } else Snackbar.make(shipping_view, "Please select a shipping method", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        when(group?.checkedRadioButtonId){
            R.id.rb_JTExpress -> {
                shipping_method_id = "flat_rate"
                shipping_method_title = "Flat Rate"
                shipping_fee = 150.00
            }
        }
    }

    private fun initOnClickListeners() {
        buttonBackShipping.setOnClickListener(this)
        buttonContinueToPayment.setOnClickListener(this)
        rg_shipping.setOnCheckedChangeListener(this)
    }

    private fun gotoNewActivity(activity : Activity) {
        val i = Intent (this, activity::class.java)
        i.putExtra("address_1", address_1)
        i.putExtra("city", city)
        i.putExtra("country", country)
        i.putExtra("email", email)
        i.putExtra("first_name", first_name)
        i.putExtra("last_name", last_name)
        i.putExtra("phone", phone)
        i.putExtra("postcode", postcode)
        i.putExtra("state", state)
        i.putExtra("subtotal", subtotal)

        i.putExtra("shipping_method_id", shipping_method_id)
        i.putExtra("shipping_method_title", shipping_method_title)
        i.putExtra("shipping_fee", shipping_fee)
        startActivity(i)
    }

    private fun getExtras() {
        val b: Bundle? = intent.extras
        if(b != null){
            address_1 = b.getString("address_1").toString()
            city = b.getString("city").toString()
            country = b.getString("country").toString()
            email = b.getString("email").toString()
            first_name = b.getString("first_name").toString()
            last_name = b.getString("last_name").toString()
            phone = b.getString("phone").toString()
            postcode = b.getString("postcode").toString()
            state = b.getString("state").toString()
            subtotal = b.getDouble("subtotal")
        }
    }

    private fun setTexts() {
        val fullAddress = "${address_1}, ${postcode}, ${country}"
        editText_fullAddress.text = fullAddress
        editText_fullAddress.inputType = InputType.TYPE_NULL
        textview_shiprate.text = currencyFormatter(150.00)
    }

    fun currencyFormatter(mNumber: Double): String
    {
        val mNumberFormat: NumberFormat = NumberFormat.getCurrencyInstance()
        mNumberFormat.maximumFractionDigits = 2
        mNumberFormat.currency = Currency.getInstance("PHP")
        return (mNumberFormat.format(mNumber)).toString()
    }
}