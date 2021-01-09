package com.ecommerce.lessconsumo.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ecommerce.lessconsumo.R
import kotlinx.android.synthetic.main.activity_confirmation.*

class ConfirmationActivity : AppCompatActivity(), View.OnClickListener{

    private var responseID = 0
    private lateinit var responseStatus: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        initOnClickListener()
        getExtras()
        setTexts()
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.buttonBackConfirmation -> backToHome()
        }
    }

    private fun initOnClickListener() {
        buttonBackConfirmation.setOnClickListener(this)
    }

    private fun backToHome() {
        val i = Intent(this, HomeActivity::class.java)
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(i)
    }

    private fun setTexts() {
        tv_ID.text = "Order ID: $responseID"
        tv_status.text = "Order Status: $responseStatus"
    }

    private fun getExtras() {
        val b = intent.extras
        if(b != null) {
            responseID = b.getInt("responseID")
            responseStatus = b.getString("responseStatus").toString()
        }
    }
}