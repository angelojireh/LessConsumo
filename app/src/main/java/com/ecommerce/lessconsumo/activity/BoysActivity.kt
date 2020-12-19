package com.ecommerce.lessconsumo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.ecommerce.lessconsumo.R
import com.ecommerce.lessconsumo.adapters.BoysAdapter
import com.example.lesscon.home.data.ProductModel
import com.example.lesscon.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_boys.*

class BoysActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mHomeViewModel: HomeViewModel
    private lateinit var mBoysAdapter: BoysAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boys)

        initButtonListeners()
        initAdapter()
        loadBoys()
    }

    override fun onClick(p0: View?) {
        when(p0?.id)
        {
            R.id.buttonBackBoys -> finishMe()
        }
    }

    private fun initButtonListeners() {
        buttonBackBoys.setOnClickListener(this)
    }

    private fun finishMe()
    {
        this.finish()
    }

    private fun showToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

    private fun loadBoys()
    {
        mHomeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        mHomeViewModel.fetchBoys()
        mHomeViewModel.productModelListLiveData?.observe(this, Observer {
            if (it != null)
            {
                recyclerView_boys.visibility =  View.VISIBLE
                mBoysAdapter.setData(it as ArrayList<ProductModel>)
            }
            else
            {
                showToast("Something went wrong \nit value: $it")
            }
            progressbar.visibility = View.GONE
        })
    }

    private fun initAdapter()
    {
        mBoysAdapter = BoysAdapter(this)
        recyclerView_boys.layoutManager = GridLayoutManager(this, 2)
        recyclerView_boys.adapter = mBoysAdapter
    }
}