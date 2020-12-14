package com.ecommerce.lessconsumo.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ecommerce.lessconsumo.R
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        onClicks()

    }

    private fun onClicks() {
        // setup
        buttonBack.setOnClickListener {
            finishMe()
        }
    }

    /*private fun gotoNewActivity(activity : Activity) {
        val intent = Intent (this, activity::class.java)
        startActivity(intent)
    }*/

    private fun finishMe()
    {
        this.finish()
    }
}