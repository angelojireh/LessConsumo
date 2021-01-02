package com.ecommerce.lessconsumo.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ecommerce.lessconsumo.R
import kotlinx.android.synthetic.main.activity_profiles.*

class ProfilesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profiles)

        buttonBackProfile.setOnClickListener {
            this.finish()
        }
        buttonCartProfile.setOnClickListener {
            gotoNewActivity(CartActivity())
        }
        buttonEdit.setOnClickListener {
            Toast.makeText(this, "This feature is not yet available.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun gotoNewActivity(activity : Activity) {
        val intent = Intent (this, activity::class.java)
        startActivity(intent)
    }
}