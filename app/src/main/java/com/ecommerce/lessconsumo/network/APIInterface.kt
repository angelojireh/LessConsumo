package com.example.lesscon.network

import com.example.lesscon.home.data.ProductModel
import retrofit2.Call
import retrofit2.http.GET

interface APIInterface
{
    @GET("products?per_page=15")
    fun fetchAllProducts(): Call<List<ProductModel>>

    @GET("products?on_sale=true&per_page=15")
    fun fetchOnSaleProducts(): Call<List<ProductModel>>

    @GET("products?order_by=date&order=desc&per_page=15")
    fun fetchNewProducts(): Call<List<ProductModel>>

    @GET("products?search=bag&per_page=15")
    fun fetchBags(): Call<List<ProductModel>>

    @GET("products?search=bottoms&per_page=15")
    fun fetchBottoms(): Call<List<ProductModel>>

    @GET("products?search=boys&per_page=15")
    fun fetchBoys(): Call<List<ProductModel>>

    @GET("products?search=dress&per_page=15")
    fun fetchDresses(): Call<List<ProductModel>>

    @GET("products?search=girls&per_page=15")
    fun fetchGirls(): Call<List<ProductModel>>

    @GET("products?search=men+bottoms&per_page=15")
    fun fetchMenBottoms(): Call<List<ProductModel>>

    @GET("products?search=men+tops&per_page=15")
    fun fetchMenTops(): Call<List<ProductModel>>

    @GET("products?search=shoes&per_page=15")
    fun fetchShoes(): Call<List<ProductModel>>

    @GET("products?search=tops&per_page=15")
    fun fetchTops(): Call<List<ProductModel>>
}