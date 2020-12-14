package com.ecommerce.lessconsumo.activity


import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ecommerce.lessconsumo.R
import com.ecommerce.lessconsumo.adapters.NewProductsAdapter
import com.ecommerce.lessconsumo.adapters.SaleProductsAdapter
import com.example.lesscon.home.data.GetModel
import com.example.lesscon.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private lateinit var mHomeViewModel: HomeViewModel
    private lateinit var mSaleProductsAdapter: SaleProductsAdapter
    private lateinit var mNewProductsAdapter: NewProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        onClicks()
        initNewProductsAdapter()
        loadNewArrivals()
        initSaleProductsAdapter()
        loadSaleProducts()

    }

    private fun onClicks() {
        // setup
        var buttonTops = findViewById<LinearLayout>(R.id.buttonTops)

        buttonTops.setOnClickListener {
            gotoNewActivity(ProductActivity())
        }
    }

    private fun gotoNewActivity(activity : Activity) {
        val intent = Intent (this, activity::class.java)
        startActivity(intent)
    }

    private fun showToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

    private fun loadNewArrivals() {
        //load new arrivals
        mHomeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        mHomeViewModel.fetchNewProducts()
        mHomeViewModel.getModelListLiveData?.observe(this, Observer {
            if (it != null)
            {
                recyclerView_newArrivals.visibility =  View.VISIBLE
                mNewProductsAdapter.setData(it as ArrayList<GetModel>)
            }
            else
            {
                showToast("Something went wrong \nit value: $it")
            }
            progress_newProducts.visibility = View.GONE
        })
    }

    private fun loadSaleProducts() {
        // load sale products
        mHomeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        mHomeViewModel.fetchOnSaleProducts()
        mHomeViewModel.getModelListLiveData?.observe(this, Observer {
            if (it != null)
            {
                recyclerView_saleProducts.visibility =  View.VISIBLE
                mSaleProductsAdapter.setData(it as ArrayList<GetModel>)
            }
            else
            {
                showToast("Something went wrong \nit value: $it")
            }
            progress_saleProducts.visibility = View.GONE
        })
    }

    private fun initSaleProductsAdapter() {
        mSaleProductsAdapter = SaleProductsAdapter()
        recyclerView_saleProducts.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView_saleProducts.adapter = mSaleProductsAdapter
    }

    private fun initNewProductsAdapter() {
        mNewProductsAdapter = NewProductsAdapter()
        recyclerView_newArrivals.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView_newArrivals.adapter = mNewProductsAdapter
    }
}