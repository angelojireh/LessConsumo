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

    @GET("products?stock_quantity=1&on_sale=true")
    fun fetchOnSaleProducts(@Query("page") page: Int): Call<List<ProductModel>>

    @GET("products?stock_quantity=1&order_by=date&order=desc")
    fun fetchNewProducts(@Query("page") page: Int): Call<List<ProductModel>>

    @GET("products?search=bag&stock_quantity=1")
    fun fetchBags(@Query("page") page: Int): Call<List<ProductModel>>

    @GET("products?search=bottoms&stock_quantity=1")
    fun fetchBottoms(@Query("page") page: Int): Call<List<ProductModel>>

    @GET("products?search=boys&stock_quantity=1")
    fun fetchBoys(@Query("page") page: Int): Call<List<ProductModel>>

    @GET("products?search=dress&stock_quantity=1")
    fun fetchDresses(@Query("page") page: Int): Call<List<ProductModel>>

    @GET("products?search=girls&stock_quantity=1")
    fun fetchGirls(@Query("page") page: Int): Call<List<ProductModel>>

    @GET("products?search=men+pants&stock_quantity=1")
    fun fetchMenBottoms(@Query("page") page: Int): Call<List<ProductModel>>

    @GET("products?search=men+top&stock_quantity=1")
    fun fetchMenTops(@Query("page") page: Int): Call<List<ProductModel>>

    @GET("products?search=shoes&stock_quantity=1")
    fun fetchShoes(@Query("page") page: Int): Call<List<ProductModel>>

    @GET("products?search=top&stock_quantity=1")
    fun fetchTops(@Query("page") page: Int): Call<List<ProductModel>>

    @GET("products?stock_quantity=1")
    fun searchItems(@Query("search") item: String): Call<List<ProductModel>>

    @POST("orders")
    fun postOrder(@Body orderData: OrderModel): Call<OrderResponseModel>
}