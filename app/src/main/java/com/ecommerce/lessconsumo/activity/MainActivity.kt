package com.ecommerce.lessconsumo.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.ecommerce.lessconsumo.R
import com.ecommerce.lessconsumo.customclass.CommonStatusBarColor

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // color of status bar
        val commonStatusBarColorObj = CommonStatusBarColor()
        commonStatusBarColorObj.statusBarColor(this,"#F00674")

        // setup
        val lc_logo = findViewById<ImageView>(R.id.lc_logo)

        // 3 seconds -> go to HomeActivity
        lc_logo.alpha = 0f
        lc_logo.animate().setDuration(3000).alpha(1f).withEndAction {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}