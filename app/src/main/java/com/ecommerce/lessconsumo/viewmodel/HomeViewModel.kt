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

    fun fetchOnSaleProducts(page: Int)
    {
        productModelListLiveData = homeRepository?.fetchOnSaleProducts(page)
    }

    fun fetchNewProducts(page: Int)
    {
        productModelListLiveData = homeRepository?.fetchNewProducts(page)
    }

    fun fetchBags(page: Int)
    {
        productModelListLiveData = homeRepository?.fetchBags(page)
    }

    fun fetchBottoms(page: Int)
    {
        productModelListLiveData = homeRepository?.fetchBottoms(page)
    }

    fun fetchBoys(page: Int)
    {
        productModelListLiveData = homeRepository?.fetchBoys(page)
    }

    fun fetchDresses(page: Int)
    {
        productModelListLiveData = homeRepository?.fetchDresses(page)
    }

    fun fetchGirls(page: Int)
    {
        productModelListLiveData = homeRepository?.fetchGirls(page)
    }

    fun fetchMenBottoms(page: Int)
    {
        productModelListLiveData = homeRepository?.fetchMenBottoms(page)
    }

    fun fetchMenTops(page: Int)
    {
        productModelListLiveData = homeRepository?.fetchMenTops(page)
    }

    fun fetchShoes(page: Int)
    {
        productModelListLiveData = homeRepository?.fetchShoes(page)
    }

    fun fetchTops(page: Int)
    {
        productModelListLiveData = homeRepository?.fetchTops(page)
    }

    fun searchItems(item: String)
    {
        productModelListLiveData = homeRepository?.searchItems(item)
    }
}