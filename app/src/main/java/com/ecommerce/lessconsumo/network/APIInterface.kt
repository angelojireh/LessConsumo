package com.example.lesscon.network

import com.example.lesscon.home.data.GetModel
import retrofit2.Call
import retrofit2.http.GET

interface APIInterface
{
    @GET("products?per_page=15")
    fun fetchAllProducts(): Call<List<GetModel>>

    @GET("products?on_sale=true&per_page=15")
    fun fetchOnSaleProducts(): Call<List<GetModel>>

    @GET("products?order_by=date&order=desc&per_page=15")
    fun fetchNewProducts(): Call<List<GetModel>>
}