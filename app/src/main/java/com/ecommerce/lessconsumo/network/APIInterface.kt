package com.example.lesscon.network

import com.ecommerce.lessconsumo.data.OrderModel
import com.ecommerce.lessconsumo.data.OrderResponseModel
import com.example.lesscon.home.data.ProductModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface APIInterface
{
    @GET("products")
    fun fetchAllProducts(): Call<List<ProductModel>>

    @GET("products?on_sale=true")
    fun fetchOnSaleProducts(@Query("page") page: Int): Call<List<ProductModel>>

    @GET("products?order_by=date&order=desc")
    fun fetchNewProducts(@Query("page") page: Int): Call<List<ProductModel>>

    @GET("products?search=bag")
    fun fetchBags(@Query("page") page: Int): Call<List<ProductModel>>

    @GET("products?search=bottoms")
    fun fetchBottoms(@Query("page") page: Int): Call<List<ProductModel>>

    @GET("products?search=boys")
    fun fetchBoys(@Query("page") page: Int): Call<List<ProductModel>>

    @GET("products?search=dress")
    fun fetchDresses(@Query("page") page: Int): Call<List<ProductModel>>

    @GET("products?search=girls")
    fun fetchGirls(@Query("page") page: Int): Call<List<ProductModel>>

    @GET("products?search=men+bottoms")
    fun fetchMenBottoms(@Query("page") page: Int): Call<List<ProductModel>>

    @GET("products?search=men+tops")
    fun fetchMenTops(@Query("page") page: Int): Call<List<ProductModel>>

    @GET("products?search=shoes")
    fun fetchShoes(@Query("page") page: Int): Call<List<ProductModel>>

    @GET("products?search=tops")
    fun fetchTops(@Query("page") page: Int): Call<List<ProductModel>>

    @GET("products")
    fun searchItems(@Query("search") item: String): Call<List<ProductModel>>

    @POST("orders")
    fun postOrder(@Body orderData: OrderModel): Call<OrderResponseModel>
}