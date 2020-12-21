package com.ecommerce.lessconsumo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ecommerce.lessconsumo.R
import com.ecommerce.lessconsumo.adapters.SearchAdapter
import com.example.lesscon.home.data.ProductModel
import com.example.lesscon.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var mHomeViewModel: HomeViewModel
    private lateinit var mSearchAdapter: SearchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        initButtonListeners()
        initSearchAdapter()
        initSearchBarSuggestions()
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.buttonBackSearch -> this.finish()
            R.id.buttonSearchLC -> loadSearch()
        }
    }

    private fun initButtonListeners() {
        buttonBackSearch.setOnClickListener(this)
        buttonSearchLC.setOnClickListener(this)
        editText_search.setOnEditorActionListener { v, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_SEARCH)
            {
                loadSearch()
                true
            } else false
        }
    }

    private fun initSearchAdapter()
    {
        mSearchAdapter = SearchAdapter(this)
        recyclerView_search.layoutManager = GridLayoutManager(this, 2)
        recyclerView_search.adapter = mSearchAdapter
    }

    private fun initSearchBarSuggestions()
    {
        val searchSuggestions: Array<out String> = resources.getStringArray(R.array.search_suggestions)
        ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, searchSuggestions).also { adapter ->
            editText_search.setAdapter(adapter)
        }
    }

    private fun showToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

    private fun loadSearch()
    {
        progressbar.visibility = View.VISIBLE
        mHomeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        mHomeViewModel.searchItems(editText_search.text.toString())
        mHomeViewModel.productModelListLiveData?.observe(this, Observer {
            if (it != null)
            {
                recyclerView_search.visibility =  View.VISIBLE
                mSearchAdapter.setData(it as ArrayList<ProductModel>)
            }
            else
            {
                showToast("Something went wrong \nit value: $it")
            }
            progressbar.visibility = View.GONE
        })
    }
}