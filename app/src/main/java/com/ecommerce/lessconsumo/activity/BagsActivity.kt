package com.ecommerce.lessconsumo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.ecommerce.lessconsumo.R
import com.ecommerce.lessconsumo.adapters.BagsAdapter
import com.example.lesscon.home.data.GetModel
import com.example.lesscon.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_bags.*

class BagsActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var mHomeViewModel: HomeViewModel
    private lateinit var mBagsAdapter: BagsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bags)

        initButtonListeners()
        initAdapter()
        loadBags()
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
    {
        mHomeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        mHomeViewModel.fetchBags()
        mHomeViewModel.getModelListLiveData?.observe(this, Observer {
            if (it != null)
            {
                recyclerView_bags.visibility =  View.VISIBLE
                mBagsAdapter.setData(it as ArrayList<GetModel>)
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
        mBagsAdapter = BagsAdapter(this)
        recyclerView_bags.layoutManager = GridLayoutManager(this, 2)
        recyclerView_bags.adapter = mBagsAdapter
    }

}