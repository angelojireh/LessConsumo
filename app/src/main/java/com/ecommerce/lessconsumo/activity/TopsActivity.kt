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
import kotlinx.android.synthetic.main.activity_tops.*

class TopsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mHomeViewModel: HomeViewModel
    private lateinit var mTopsAdapter: CategoriesAdapter

    private lateinit var mGridLayoutManager: GridLayoutManager
    private var page = 1
    private var isLoading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tops)

        initButtonListeners()
        initAdapter()
        loadTops(page)
        addScrollListener()
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.buttonBackTops -> this.finish()
            R.id.action_bar -> recyclerView_tops.smoothScrollToPosition(0)
            R.id.buttonCart -> gotoNewActivity(CartActivity())
        }
    }

    private fun initButtonListeners() {
        buttonBackTops.setOnClickListener(this)
        action_bar.setOnClickListener(this)
        buttonCart.setOnClickListener(this)
    }

    private fun gotoNewActivity(activity: Activity) {
        val i = Intent(this, activity::class.java)
        startActivity(i)
    }

    private fun loadTops(page: Int) {
        isLoading = true
        mHomeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        mHomeViewModel.fetchTops(page)
        mHomeViewModel.productModelListLiveData?.observe(this, Observer {
            if (it != null) {
                recyclerView_tops.visibility = View.VISIBLE
                mTopsAdapter.setData(it as ArrayList<ProductModel>)
            }
            progressbar.visibility = View.GONE
            isLoading = false
        })
    }

    private fun initAdapter() {
        mGridLayoutManager = GridLayoutManager(this, 2)
        mTopsAdapter = CategoriesAdapter(this)
        recyclerView_tops.setHasFixedSize(true)
        recyclerView_tops.layoutManager = mGridLayoutManager
        recyclerView_tops.adapter = mTopsAdapter
    }

    private fun addScrollListener() {
        recyclerView_tops.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) {
                    if (!isLoading) {
                        page++
                        loadTops(page)
                    }
                }
                if (recyclerView_tops.computeVerticalScrollOffset() > 1000) {
                    action_bar.visibility = View.VISIBLE
                } else action_bar.visibility = View.INVISIBLE
            }
        })
    }
}