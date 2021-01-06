package com.ecommerce.lessconsumo.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ecommerce.lessconsumo.R
import com.ecommerce.lessconsumo.adapters.CategoriesAdapter
import com.example.lesscon.home.data.ProductModel
import com.example.lesscon.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_bottoms.*

class BottomsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mHomeViewModel: HomeViewModel
    private lateinit var mBottomsAdapter: CategoriesAdapter

    private lateinit var mGridLayoutManager: GridLayoutManager
    private var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottoms)

        initButtonListeners()
        initAdapter()
        loadBottoms(page)
        addScrollListener()
    }

    override fun onClick(p0: View?) {
        when(p0?.id)
        {
            R.id.buttonBackBottoms -> finishMe()
        }
    }

    private fun initButtonListeners() {
        buttonBackBottoms.setOnClickListener(this)
    }

    private fun finishMe()
    {
        this.finish()
    }

    private fun showToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

    private fun loadBottoms(page: Int)
    {
        mHomeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        mHomeViewModel.fetchBottoms(page)
        mHomeViewModel.productModelListLiveData?.observe(this, Observer {
            if (it != null)
            {
                recyclerView_bottoms.visibility =  View.VISIBLE
                mBottomsAdapter.setData(it as ArrayList<ProductModel>)
            }
            progressbar.visibility = View.GONE
        })
    }

    private fun initAdapter()
    {
        mGridLayoutManager = GridLayoutManager(this, 2)
        mBottomsAdapter = CategoriesAdapter(this)
        recyclerView_bottoms.setHasFixedSize(true)
        recyclerView_bottoms.layoutManager = mGridLayoutManager
        recyclerView_bottoms.adapter = mBottomsAdapter
    }

    private fun addScrollListener(){
        recyclerView_bottoms.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if(dy > 0) {
                    val visibleItemCount = mGridLayoutManager.childCount
                    val totalItemCount = mGridLayoutManager.itemCount
                    val pastVisibleItems = mGridLayoutManager.findFirstVisibleItemPosition()
                    if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                        page++
                        loadBottoms(page)
                    }
                }
            }
        })
    }
}