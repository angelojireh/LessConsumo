package com.example.lesscon.home.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.lesscon.home.data.ProductModel
import com.example.lesscon.home.data.HomeRepository

class HomeViewModel(application: Application): AndroidViewModel(application)
{

    private var homeRepository: HomeRepository? = null
    var productModelListLiveData : LiveData<List<ProductModel>>? = null

    init
    {
        homeRepository = HomeRepository()
        productModelListLiveData = MutableLiveData()
    }

    fun fetchAllProducts()
    {
        productModelListLiveData = homeRepository?.fetchAllProducts()
    }

    fun fetchOnSaleProducts()
    {
        productModelListLiveData = homeRepository?.fetchOnSaleProducts()
    }

    fun fetchNewProducts()
    {
        productModelListLiveData = homeRepository?.fetchNewProducts()
    }

    fun fetchBags()
    {
        productModelListLiveData = homeRepository?.fetchBags()
    }

    fun fetchBottoms()
    {
        productModelListLiveData = homeRepository?.fetchBottoms()
    }

    fun fetchBoys()
    {
        productModelListLiveData = homeRepository?.fetchBoys()
    }

    fun fetchDresses()
    {
        productModelListLiveData = homeRepository?.fetchDresses()
    }

    fun fetchGirls()
    {
        productModelListLiveData = homeRepository?.fetchGirls()
    }

    fun fetchMenBottoms()
    {
        productModelListLiveData = homeRepository?.fetchMenBottoms()
    }

    fun fetchMenTops()
    {
        productModelListLiveData = homeRepository?.fetchMenTops()
    }

    fun fetchShoes()
    {
        productModelListLiveData = homeRepository?.fetchShoes()
    }

    fun fetchTops()
    {
        productModelListLiveData = homeRepository?.fetchTops()
    }
}