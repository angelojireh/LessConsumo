package com.ecommerce.lessconsumo.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.ecommerce.lessconsumo.R
import com.ecommerce.lessconsumo.adapters.ShoesAdapter
import com.example.lesscon.home.data.GetModel
import com.example.lesscon.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_shoes.*

class ShoesActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mHomeViewModel: HomeViewModel
    private lateinit var mShoesAdapter: ShoesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shoes)

        initButtonListeners()
        initAdapter()
        loadShoes()
    }

    override fun onClick(p0: View?) {
        when(p0?.id)
        {
            R.id.buttonBackShoes -> finishMe()
        }
    }

    private fun initButtonListeners() {
        buttonBackShoes.setOnClickListener(this)
    }

    private fun finishMe()
    {
        this.finish()
    }

    private fun showToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

    private fun loadShoes()
    {
        mHomeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        mHomeViewModel.fetchShoes()
        mHomeViewModel.getModelListLiveData?.observe(this, Observer {
            if (it != null)
            {
                recyclerView_shoes.visibility =  View.VISIBLE
                mShoesAdapter.setData(it as ArrayList<GetModel>)
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
        mShoesAdapter = ShoesAdapter(this)
        recyclerView_shoes.layoutManager = GridLayoutManager(this, 2)
        recyclerView_shoes.adapter = mShoesAdapter
    }
}