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
import kotlinx.android.synthetic.main.activity_men_tops.*

class MenTopsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mHomeViewModel: HomeViewModel
    private lateinit var mMenTopsAdapter: CategoriesAdapter

    private lateinit var mGridLayoutManager: GridLayoutManager
    private var page = 1
    private var isLoading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_men_tops)

        initButtonListeners()
        initAdapter()
        loadMenTops(page)
        addScrollListener()
    }

    override fun onClick(p0: View?) {
        when(p0?.id)
        {
            R.id.buttonBackMenTops -> this.finish()
            R.id.action_bar -> recyclerView_menTops.smoothScrollToPosition(0)
            R.id.buttonCart -> gotoNewActivity(CartActivity())
        }
    }

    private fun initButtonListeners() {
        buttonBackMenTops.setOnClickListener(this)
        action_bar.setOnClickListener(this)
        buttonCart.setOnClickListener(this)
    }

    private fun gotoNewActivity(activity: Activity) {
        val i = Intent(this, activity::class.java)
        startActivity(i)
    }

    private fun loadMenTops(page: Int)
    {
        isLoading = true
        mHomeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        mHomeViewModel.fetchMenTops(page)
        mHomeViewModel.productModelListLiveData?.observe(this, Observer {
            if (it != null)
            {
                recyclerView_menTops.visibility =  View.VISIBLE
                mMenTopsAdapter.setData(it as ArrayList<ProductModel>)
            }
            progressbar.visibility = View.GONE
            isLoading = false
        })
    }

    private fun initAdapter()
    {
        mGridLayoutManager = GridLayoutManager(this, 2)
        mMenTopsAdapter = CategoriesAdapter(this)
        recyclerView_menTops.setHasFixedSize(true)
        recyclerView_menTops.layoutManager = mGridLayoutManager
        recyclerView_menTops.adapter = mMenTopsAdapter
    }

    private fun addScrollListener(){
        recyclerView_menTops.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if(dy > 0) {
                    if(!isLoading){
                        page++
                        loadMenTops(page)
                    }
                }
                if (recyclerView_menTops.computeVerticalScrollOffset() > 1000) {
                    action_bar.visibility = View.VISIBLE
                } else action_bar.visibility = View.INVISIBLE
            }
        })
    }
}