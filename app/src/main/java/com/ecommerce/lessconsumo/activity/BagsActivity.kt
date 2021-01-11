package com.ecommerce.lessconsumo.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ecommerce.lessconsumo.R
import com.ecommerce.lessconsumo.adapters.CategoriesAdapter
import com.example.lesscon.home.data.ProductModel
import com.example.lesscon.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_bags.*

class BagsActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var mHomeViewModel: HomeViewModel
    private lateinit var mBagsAdapter: CategoriesAdapter

    private lateinit var mGridLayoutManager: GridLayoutManager
    private var page = 1
    private var isLoading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bags)

        initButtonListeners()
        initAdapter()
        loadBags(page)
        addScrollListener()
    }

    override fun onClick(p0: View?) {
        when(p0?.id)
        {
            R.id.buttonBackBags -> this.finish()
            R.id.action_bar -> recyclerView_bags.smoothScrollToPosition(0)
            R.id.buttonCart -> gotoNewActivity(CartActivity())
        }
    }

    private fun initButtonListeners() {
        buttonBackBags.setOnClickListener(this)
        action_bar.setOnClickListener(this)
        buttonCart.setOnClickListener(this)
    }

    private fun gotoNewActivity(activity: Activity) {
        val i = Intent(this, activity::class.java)
        startActivity(i)
    }

    private fun loadBags(page: Int)
    {
        isLoading = true
        mHomeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        mHomeViewModel.fetchBags(page)
        mHomeViewModel.productModelListLiveData?.observe(this, Observer {
            if (it != null)
            {
                recyclerView_bags.visibility =  View.VISIBLE
                mBagsAdapter.setData(it as ArrayList<ProductModel>)
            }
            progressbar.visibility = View.GONE
            isLoading = false
        })
    }

    private fun initAdapter()
    {
        mGridLayoutManager = GridLayoutManager(this, 2)
        mBagsAdapter = CategoriesAdapter(this)
        recyclerView_bags.setHasFixedSize(true)
        recyclerView_bags.layoutManager = mGridLayoutManager
        recyclerView_bags.adapter = mBagsAdapter
    }

    private fun addScrollListener(){
        recyclerView_bags.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if(dy > 0) {
                    //load more products asynchronously
                    if(!isLoading){
                        page++
                        loadBags(page)
                    }
                }
                if (recyclerView_bags.computeVerticalScrollOffset() > 1000) {
                    action_bar.visibility = View.VISIBLE
                } else action_bar.visibility = View.INVISIBLE
            }
        })
    }
}