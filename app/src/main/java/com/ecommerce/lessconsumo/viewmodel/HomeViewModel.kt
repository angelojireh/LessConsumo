package com.example.lesscon.home.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.lesscon.home.data.GetModel
import com.example.lesscon.home.data.HomeRepository

class HomeViewModel(application: Application): AndroidViewModel(application)
{

    private var homeRepository: HomeRepository? = null
    var getModelListLiveData : LiveData<List<GetModel>>? = null

    init
    {
        homeRepository = HomeRepository()
        getModelListLiveData = MutableLiveData()
    }

    fun fetchAllProducts()
    {
        getModelListLiveData = homeRepository?.fetchAllProducts()
    }

    fun fetchOnSaleProducts()
    {
        getModelListLiveData = homeRepository?.fetchOnSaleProducts()
    }

    fun fetchNewProducts()
    {
        getModelListLiveData = homeRepository?.fetchNewProducts()
    }

    fun fetchBags()
    {
        getModelListLiveData = homeRepository?.fetchBags()
    }
}