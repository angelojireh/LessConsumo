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
import com.ecommerce.lessconsumo.adapters.DressesAdapter
import com.example.lesscon.home.data.GetModel
import com.example.lesscon.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_dresses.*

class DressesActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var mHomeViewModel: HomeViewModel
    private lateinit var mDressesAdapter: DressesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dresses)

        initButtonListeners()
        initAdapter()
        loadDresses()
    }

    override fun onClick(p0: View?) {
        when(p0?.id)
        {
            R.id.buttonBackDresses -> finishMe()
        }
    }

    private fun initButtonListeners() {
        buttonBackDresses.setOnClickListener(this)
    }

    private fun finishMe()
    {
        this.finish()
    }

    private fun showToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

    private fun loadDresses()
    {
        mHomeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        mHomeViewModel.fetchDresses()
        mHomeViewModel.getModelListLiveData?.observe(this, Observer {
            if (it != null)
            {
                recyclerView_dresses.visibility =  View.VISIBLE
                mDressesAdapter.setData(it as ArrayList<GetModel>)
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
        mDressesAdapter = DressesAdapter(this)
        recyclerView_dresses.layoutManager = GridLayoutManager(this, 2)
        recyclerView_dresses.adapter = mDressesAdapter
    }
}