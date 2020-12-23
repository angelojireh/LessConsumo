package com.ecommerce.lessconsumo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ecommerce.lessconsumo.R
import com.ecommerce.lessconsumo.adapters.MenTopsAdapter
import com.example.lesscon.home.data.ProductModel
import com.example.lesscon.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_men_tops.*
import kotlinx.android.synthetic.main.activity_men_tops.progressbar

class MenTopsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mHomeViewModel: HomeViewModel
    private lateinit var mMenTopsAdapter: MenTopsAdapter

    private lateinit var mGridLayoutManager: GridLayoutManager
    private var page = 1

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
            R.id.buttonBackMenTops -> finishMe()
        }
    }

    private fun initButtonListeners() {
        buttonBackMenTops.setOnClickListener(this)
    }

    private fun finishMe()
    {
        this.finish()
    }

    private fun showToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

    private fun loadMenTops(page: Int)
    {
        mHomeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        mHomeViewModel.fetchMenTops(page)
        mHomeViewModel.productModelListLiveData?.observe(this, Observer {
            if (it != null)
            {
                recyclerView_menTops.visibility =  View.VISIBLE
                mMenTopsAdapter.setData(it as ArrayList<ProductModel>)
            }
            progressbar.visibility = View.GONE
        })
    }

    private fun initAdapter()
    {
        mGridLayoutManager = GridLayoutManager(this, 2)
        mMenTopsAdapter = MenTopsAdapter(this)
        recyclerView_menTops.setHasFixedSize(true)
        recyclerView_menTops.layoutManager = mGridLayoutManager
        recyclerView_menTops.adapter = mMenTopsAdapter
    }

    private fun addScrollListener(){
        recyclerView_menTops.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if(dy > 0) {
                    val visibleItemCount = mGridLayoutManager.childCount
                    val totalItemCount = mGridLayoutManager.itemCount
                    val pastVisibleItems = mGridLayoutManager.findFirstVisibleItemPosition()
                    if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                        page++
                        loadMenTops(page)
                    }
                }
            }
        })
    }
}