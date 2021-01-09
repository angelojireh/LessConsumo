package com.ecommerce.lessconsumo.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.text.Editable
import android.text.InputType
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ecommerce.lessconsumo.R
import io.paperdb.Paper
import kotlinx.android.synthetic.main.activity_information.*

class InformationActivity : AppCompatActivity(), View.OnClickListener {

    private var subtotal = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)

        Paper.init(applicationContext)
        initOnClickListeners()
        getExtras()
        setTexts()
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.buttonBackInformation -> this.finish()
            R.id.buttonContinue -> {
                gotoShippingActivity(ShippingActivity())
            }
        }
    }

    private fun initOnClickListeners()
    {
        buttonBackInformation.setOnClickListener(this)
        buttonContinue.setOnClickListener(this)
    }

    private fun gotoShippingActivity(activity : Activity) {
        val address_1 = edittext_addressLine1.text.trim().toString()
        val city = edittext_city.text.trim().toString()
        val country = edittext_country.text.trim().toString()
        val email = edittext_email.text.trim().toString()
        val first_name = edittext_firstName.text.trim().toString()
        val last_name = edittext_lastName.text.trim().toString()
        val phone = edittext_mobileNumber.text.trim().toString()
        val postcode = edittext_zip.text.trim().toString()
        val state = edittext_state.text.trim().toString()

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
        startActivity(i)
    }

    private fun getExtras(){
        subtotal = intent.getDoubleExtra("subtotal", 0.00)
    }

    private fun setTexts() {
        edittext_country.setText("PH")
        edittext_country.inputType = InputType.TYPE_NULL
    }
}