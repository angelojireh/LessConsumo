package com.ecommerce.lessconsumo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.ecommerce.lessconsumo.R
import com.ecommerce.lessconsumo.adapters.BagsAdapter
import kotlinx.android.synthetic.main.activity_bags.*
import kotlinx.android.synthetic.main.activity_dresses.*

class BagsActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bags)

        initButtonListeners()

    }

    override fun onClick(p0: View?) {
        when(p0?.id)
        {
            R.id.buttonBackBags -> finishMe()
        }
    }

    private fun initButtonListeners() {
        buttonBackBags.setOnClickListener(this)
    }

    private fun finishMe()
    {
        this.finish()
    }

    private fun showToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

    private fun loadBags()
    {}

    private fun initBagsAdapter()
    {}

}