package com.ecommerce.lessconsumo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ecommerce.lessconsumo.R
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.activity_profiles.*

class ProfilesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profiles)

        buttonBackProfile.setOnClickListener {
            this.finish()
        }
        buttonEdit.setOnClickListener {
            Toast.makeText(this, "This feature is not yet available.", Toast.LENGTH_SHORT).show()
        }
    }
}