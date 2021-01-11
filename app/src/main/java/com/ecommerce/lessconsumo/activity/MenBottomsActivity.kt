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
import kotlinx.android.synthetic.main.activity_men_bottoms.*

class MenBottomsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mHomeViewModel: HomeViewModel
    private lateinit var mMenBottomsAdapter: CategoriesAdapter

    private lateinit var mGridLayoutManager: GridLayoutManager
    private var page = 1
    private var isLoading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_men_bottoms)

        initButtonListeners()
        initAdapter()
        loadMenBottoms(page)
        addScrollListener()
    }

    override fun onClick(p0: View?) {
        when(p0?.id)
        {
            R.id.buttonBackMenBottoms -> this.finish()
            R.id.action_bar -> recyclerView_menBottoms.smoothScrollToPosition(0)
            R.id.buttonCart -> gotoNewActivity(CartActivity())
        }
    }

    private fun initButtonListeners() {
        buttonBackMenBottoms.setOnClickListener(this)
        action_bar.setOnClickListener(this)
        buttonCart.setOnClickListener(this)
    }

    private fun gotoNewActivity(activity: Activity) {
        val i = Intent(this, activity::class.java)
        startActivity(i)
    }

    private fun loadMenBottoms(page: Int)
    {
        isLoading = true
        mHomeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        mHomeViewModel.fetchMenBottoms(page)
        mHomeViewModel.productModelListLiveData?.observe(this, Observer {
            if (it != null)
            {
                recyclerView_menBottoms.visibility =  View.VISIBLE
                mMenBottomsAdapter.setData(it as ArrayList<ProductModel>)
            }
            progressbar.visibility = View.GONE
            isLoading = false
        })
    }

    private fun initAdapter()
    {
        mGridLayoutManager = GridLayoutManager(this, 2)
        mMenBottomsAdapter = CategoriesAdapter(this)
        recyclerView_menBottoms.setHasFixedSize(true)
        recyclerView_menBottoms.layoutManager = mGridLayoutManager
        recyclerView_menBottoms.adapter = mMenBottomsAdapter
    }

    private fun addScrollListener(){
        recyclerView_menBottoms.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if(dy > 0) {
                    if(!isLoading){
                        page++
                        loadMenBottoms(page)
                    }
                }
                if (recyclerView_menBottoms.computeVerticalScrollOffset() > 1000) {
                    action_bar.visibility = View.VISIBLE
                } else action_bar.visibility = View.INVISIBLE
            }
        })
    }
}