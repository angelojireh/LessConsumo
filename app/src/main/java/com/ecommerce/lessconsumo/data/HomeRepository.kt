package com.example.lesscon.home.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ecommerce.lessconsumo.data.OrderModel
import com.ecommerce.lessconsumo.data.OrderResponseModel
import com.example.lesscon.network.APIClient
import com.example.lesscon.network.APIInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeRepository {

    private val HTTP_OK = 200
    private val HTTP_CREATED = 201
    private var apiInterface: APIInterface? = null
    init
    {
        apiInterface = APIClient.getApiClient().create(APIInterface::class.java)
    }

    fun fetchAllProducts(): LiveData<List<ProductModel>>
    {
        val data = MutableLiveData<List<ProductModel>>()
        apiInterface?.fetchAllProducts()?.enqueue(object: Callback<List<ProductModel>>
        {
            override fun onResponse(call: Call<List<ProductModel>>, response: Response<List<ProductModel>>)
            {
                Log.d("Response", "onResponse: ${response.body()}")
                val res = response.body()
                if(response.code() == HTTP_OK && res!=null)
                {
                    data.value = res
                }
                else
                {
                    data.value = null
                }
            }

            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
                data.value = null
            }

        })
        return data
    }

    fun fetchOnSaleProducts(page: Int): LiveData<List<ProductModel>>
    {
        val data = MutableLiveData<List<ProductModel>>()
        apiInterface?.fetchOnSaleProducts(page)?.enqueue(object: Callback<List<ProductModel>>
        {
            override fun onResponse(call: Call<List<ProductModel>>, response: Response<List<ProductModel>>)
            {
                Log.d("Response", "onResponse: ${response.body()}")
                val res = response.body()
                val totalPages = (response.headers().get("x-wp-totalpages"))?.toInt()
                if(response.code() == HTTP_OK && res!=null && page <= totalPages!!) {
                    data.value = res
                } else data.value = null
            }

            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
                data.value = null
            }

        })
        return data
    }

    fun fetchNewProducts(page: Int): LiveData<List<ProductModel>>
    {
        val data = MutableLiveData<List<ProductModel>>()
        apiInterface?.fetchNewProducts(page)?.enqueue(object: Callback<List<ProductModel>>
        {
            override fun onResponse(call: Call<List<ProductModel>>, response: Response<List<ProductModel>>)
            {
                Log.d("Response", "onResponse: ${response.body()}")
                val res = response.body()
                val totalPages = (response.headers().get("x-wp-totalpages"))?.toInt()
                if(response.code() == HTTP_OK && res!=null && page <= totalPages!!) {
                    data.value = res
                } else data.value = null
            }

            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
                data.value = null
            }

        })
        return data
    }

    fun fetchBags(page: Int): LiveData<List<ProductModel>>
    {
        val data = MutableLiveData<List<ProductModel>>()
        apiInterface?.fetchBags(page)?.enqueue(object: Callback<List<ProductModel>>
        {
            override fun onResponse(call: Call<List<ProductModel>>, response: Response<List<ProductModel>>)
            {
                Log.d("Response", "onResponse: ${response.body()}")
                val res = response.body()
                val totalPages = (response.headers().get("x-wp-totalpages"))?.toInt()
                if(response.code() == HTTP_OK && res!=null && page <= totalPages!!) {
                    data.value = res
                } else data.value = null
            }

            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
                data.value = null
            }

        })
        return data
    }

    fun fetchBottoms(page: Int): LiveData<List<ProductModel>>
    {
        val data = MutableLiveData<List<ProductModel>>()
        apiInterface?.fetchBottoms(page)?.enqueue(object: Callback<List<ProductModel>>
        {
            override fun onResponse(call: Call<List<ProductModel>>, response: Response<List<ProductModel>>)
            {
                Log.d("Response", "onResponse: ${response.body()}")
                val res = response.body()
                val totalPages = (response.headers().get("x-wp-totalpages"))?.toInt()
                if(response.code() == HTTP_OK && res!=null && page <= totalPages!!) {
                    data.value = res
                } else data.value = null
            }

            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
                data.value = null
            }

        })
        return data
    }

    fun fetchBoys(page: Int): LiveData<List<ProductModel>>
    {
        val data = MutableLiveData<List<ProductModel>>()
        apiInterface?.fetchBoys(page)?.enqueue(object: Callback<List<ProductModel>>
        {
            override fun onResponse(call: Call<List<ProductModel>>, response: Response<List<ProductModel>>)
            {
                Log.d("Response", "onResponse: ${response.body()}")
                val res = response.body()
                val totalPages = (response.headers().get("x-wp-totalpages"))?.toInt()
                if(response.code() == HTTP_OK && res!=null && page <= totalPages!!) {
                    data.value = res
                } else data.value = null
            }

            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
                data.value = null
            }

        })
        return data
    }

    fun fetchDresses(page: Int): LiveData<List<ProductModel>>
    {
        val data = MutableLiveData<List<ProductModel>>()
        apiInterface?.fetchDresses(page)?.enqueue(object: Callback<List<ProductModel>>
        {
            override fun onResponse(call: Call<List<ProductModel>>, response: Response<List<ProductModel>>)
            {
                Log.d("Response", "onResponse: ${response.body()}")
                val res = response.body()
                val totalPages = (response.headers().get("x-wp-totalpages"))?.toInt()
                if(response.code() == HTTP_OK && res!=null && page <= totalPages!!) {
                    data.value = res
                } else data.value = null
            }

            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
                data.value = null
            }

        })
        return data
    }

    fun fetchGirls(page: Int): LiveData<List<ProductModel>>
    {
        val data = MutableLiveData<List<ProductModel>>()
        apiInterface?.fetchGirls(page)?.enqueue(object: Callback<List<ProductModel>>
        {
            override fun onResponse(call: Call<List<ProductModel>>, response: Response<List<ProductModel>>)
            {
                Log.d("Response", "onResponse: ${response.body()}")
                val res = response.body()
                val totalPages = (response.headers().get("x-wp-totalpages"))?.toInt()
                if(response.code() == HTTP_OK && res!=null && page <= totalPages!!) {
                    data.value = res
                } else data.value = null
            }

            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
                data.value = null
            }

        })
        return data
    }

    fun fetchMenBottoms(page: Int): LiveData<List<ProductModel>>
    {
        val data = MutableLiveData<List<ProductModel>>()
        apiInterface?.fetchMenBottoms(page)?.enqueue(object: Callback<List<ProductModel>>
        {
            override fun onResponse(call: Call<List<ProductModel>>, response: Response<List<ProductModel>>)
            {
                Log.d("Response", "onResponse: ${response.body()}")
                val res = response.body()
                val totalPages = (response.headers().get("x-wp-totalpages"))?.toInt()
                if(response.code() == HTTP_OK && res!=null && page <= totalPages!!) {
                    data.value = res
                } else data.value = null
            }

            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
                data.value = null
            }

        })
        return data
    }

    fun fetchMenTops(page: Int): LiveData<List<ProductModel>>
    {
        val data = MutableLiveData<List<ProductModel>>()
        apiInterface?.fetchMenTops(page)?.enqueue(object: Callback<List<ProductModel>>
        {
            override fun onResponse(call: Call<List<ProductModel>>, response: Response<List<ProductModel>>)
            {
                Log.d("Response", "onResponse: ${response.body()}")
                val res = response.body()
                val totalPages = (response.headers().get("x-wp-totalpages"))?.toInt()
                if(response.code() == HTTP_OK && res!=null && page <= totalPages!!) {
                    data.value = res
                } else data.value = null
            }

            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
                data.value = null
            }

        })
        return data
    }

    fun fetchShoes(page: Int): LiveData<List<ProductModel>>
    {
        val data = MutableLiveData<List<ProductModel>>()
        apiInterface?.fetchShoes(page)?.enqueue(object: Callback<List<ProductModel>>
        {
            override fun onResponse(call: Call<List<ProductModel>>, response: Response<List<ProductModel>>)
            {
                Log.d("Response", "onResponse: ${response.body()}")
                val res = response.body()
                val totalPages = (response.headers().get("x-wp-totalpages"))?.toInt()
                if(response.code() == HTTP_OK && res!=null && page <= totalPages!!) {
                    data.value = res
                } else data.value = null
            }

            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
                data.value = null
            }

        })
        return data
    }

    fun fetchTops(page: Int): LiveData<List<ProductModel>>
    {
        val data = MutableLiveData<List<ProductModel>>()
        apiInterface?.fetchTops(page)?.enqueue(object: Callback<List<ProductModel>>
        {
            override fun onResponse(call: Call<List<ProductModel>>, response: Response<List<ProductModel>>)
            {
                Log.d("Response", "onResponse: ${response.body()}")
                val res = response.body()
                val totalPages = (response.headers().get("x-wp-totalpages"))?.toInt()
                if(response.code() == HTTP_OK && res!=null && page <= totalPages!!) {
                    data.value = res
                } else data.value = null
            }

            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
                data.value = null
            }

        })
        return data
    }

    fun searchItems(item: String): LiveData<List<ProductModel>>
    {
        val data = MutableLiveData<List<ProductModel>>()
        apiInterface?.searchItems(item)?.enqueue(object: Callback<List<ProductModel>>
        {
            override fun onResponse(call: Call<List<ProductModel>>, response: Response<List<ProductModel>>)
            {
                Log.d("Response", "onResponse: ${response.body()}")
                val res = response.body()
                if(response.code() == HTTP_OK && res!= null){
                    data.value = res
                } else data.value = null
            }

            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
                data.value = null
            }
        })
        return data
    }

    fun postOrder(orderData: OrderModel): LiveData<OrderResponseModel> {
        val data = MutableLiveData<OrderResponseModel>()
        apiInterface?.postOrder(orderData)?.enqueue(object: Callback<OrderResponseModel>
        {
            override fun onResponse(call: Call<OrderResponseModel>, response: Response<OrderResponseModel>) {
                Log.d("Response", "onResponse: ${response.body()}")
                val res = response.body()
                if(response.code() == HTTP_CREATED && res!= null){
                    data.value = res
                } else data.value = null
            }

            override fun onFailure(call: Call<OrderResponseModel>, t: Throwable) {
                data.value = null
            }
        })
        return data
    }
}