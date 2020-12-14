package com.ecommerce.lessconsumo.customclass

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.WindowManager

class CommonStatusBarColor {
    fun StatusBarColor(activity: Activity, colorCode: String?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = activity.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.parseColor(colorCode)
        }
    }
}