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
import kotlinx.android.synthetic.main.activity_men_bottoms.*

class MenBottomsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mHomeViewModel: HomeViewModel
    private lateinit var mMenBottomsAdapter: CategoriesAdapter

    private lateinit var mGridLayoutManager: GridLayoutManager
    private var page = 1

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
            R.id.buttonBackMenBottoms -> finishMe()
        }
    }

    private fun initButtonListeners() {
        buttonBackMenBottoms.setOnClickListener(this)
    }

    private fun finishMe()
    {
        this.finish()
    }

    private fun showToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

    private fun loadMenBottoms(page: Int)
    {
        mHomeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        mHomeViewModel.fetchMenBottoms(page)
        mHomeViewModel.productModelListLiveData?.observe(this, Observer {
            if (it != null)
            {
                recyclerView_menBottoms.visibility =  View.VISIBLE
                mMenBottomsAdapter.setData(it as ArrayList<ProductModel>)
            }
            progressbar.visibility = View.GONE
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
                    val visibleItemCount = mGridLayoutManager.childCount
                    val totalItemCount = mGridLayoutManager.itemCount
                    val pastVisibleItems = mGridLayoutManager.findFirstVisibleItemPosition()
                    if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                        page++
                        loadMenBottoms(page)
                    }
                }
            }
        })
    }
}