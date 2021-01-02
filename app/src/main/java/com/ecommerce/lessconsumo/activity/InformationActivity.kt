package com.ecommerce.lessconsumo.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ecommerce.lessconsumo.R
import kotlinx.android.synthetic.main.activity_information.*

class InformationActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)

        initOnClickListeners()
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.buttonBackInformation -> finishMe()
            R.id.buttonContinue -> gotoNewActivity(ShippingActivity())
        }
    }

    private fun initOnClickListeners()
    {
        buttonBackInformation.setOnClickListener(this)
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