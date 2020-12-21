package com.example.lesscon.home.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.lesscon.network.APIClient
import com.example.lesscon.network.APIInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeRepository {

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
                if(response.code() == 200 && res!=null)
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

    fun fetchOnSaleProducts(): LiveData<List<ProductModel>>
    {
        val data = MutableLiveData<List<ProductModel>>()
        apiInterface?.fetchOnSaleProducts()?.enqueue(object: Callback<List<ProductModel>>
        {
            override fun onResponse(call: Call<List<ProductModel>>, response: Response<List<ProductModel>>)
            {
                Log.d("Response", "onResponse: ${response.body()}")
                val res = response.body()
                val totalPages = response.headers().get("x-wp-totalpages")
                if(response.code() == 200 && res!=null)
                {
                    data.value = res
                    Log.i("onSale_total_pages", totalPages!!)
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

    fun fetchNewProducts(): LiveData<List<ProductModel>>
    {
        val data = MutableLiveData<List<ProductModel>>()
        apiInterface?.fetchNewProducts()?.enqueue(object: Callback<List<ProductModel>>
        {
            override fun onResponse(call: Call<List<ProductModel>>, response: Response<List<ProductModel>>)
            {
                Log.d("Response", "onResponse: ${response.body()}")
                val res = response.body()
                val totalPages = response.headers().get("x-wp-totalpages")
                if(response.code() == 200 && res!=null)
                {
                    data.value = res
                    Log.i("newProducts_total_pages", totalPages!!)
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

    fun fetchBags(): LiveData<List<ProductModel>>
    {
        val data = MutableLiveData<List<ProductModel>>()
        apiInterface?.fetchBags()?.enqueue(object: Callback<List<ProductModel>>
        {
            override fun onResponse(call: Call<List<ProductModel>>, response: Response<List<ProductModel>>)
            {
                Log.d("Response", "onResponse: ${response.body()}")
                val res = response.body()
                if(response.code() == 200 && res!=null)
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

    fun fetchBottoms(): LiveData<List<ProductModel>>
    {
        val data = MutableLiveData<List<ProductModel>>()
        apiInterface?.fetchBottoms()?.enqueue(object: Callback<List<ProductModel>>
        {
            override fun onResponse(call: Call<List<ProductModel>>, response: Response<List<ProductModel>>)
            {
                Log.d("Response", "onResponse: ${response.body()}")
                val res = response.body()
                if(response.code() == 200 && res!=null)
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

    fun fetchBoys(): LiveData<List<ProductModel>>
    {
        val data = MutableLiveData<List<ProductModel>>()
        apiInterface?.fetchBoys()?.enqueue(object: Callback<List<ProductModel>>
        {
            override fun onResponse(call: Call<List<ProductModel>>, response: Response<List<ProductModel>>)
            {
                Log.d("Response", "onResponse: ${response.body()}")
                val res = response.body()
                if(response.code() == 200 && res!=null)
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

    fun fetchDresses(): LiveData<List<ProductModel>>
    {
        val data = MutableLiveData<List<ProductModel>>()
        apiInterface?.fetchDresses()?.enqueue(object: Callback<List<ProductModel>>
        {
            override fun onResponse(call: Call<List<ProductModel>>, response: Response<List<ProductModel>>)
            {
                Log.d("Response", "onResponse: ${response.body()}")
                val res = response.body()
                if(response.code() == 200 && res!=null)
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

    fun fetchGirls(): LiveData<List<ProductModel>>
    {
        val data = MutableLiveData<List<ProductModel>>()
        apiInterface?.fetchGirls()?.enqueue(object: Callback<List<ProductModel>>
        {
            override fun onResponse(call: Call<List<ProductModel>>, response: Response<List<ProductModel>>)
            {
                Log.d("Response", "onResponse: ${response.body()}")
                val res = response.body()
                if(response.code() == 200 && res!=null)
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

    fun fetchMenBottoms(): LiveData<List<ProductModel>>
    {
        val data = MutableLiveData<List<ProductModel>>()
        apiInterface?.fetchMenBottoms()?.enqueue(object: Callback<List<ProductModel>>
        {
            override fun onResponse(call: Call<List<ProductModel>>, response: Response<List<ProductModel>>)
            {
                Log.d("Response", "onResponse: ${response.body()}")
                val res = response.body()
                if(response.code() == 200 && res!=null)
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

    fun fetchMenTops(): LiveData<List<ProductModel>>
    {
        val data = MutableLiveData<List<ProductModel>>()
        apiInterface?.fetchMenTops()?.enqueue(object: Callback<List<ProductModel>>
        {
            override fun onResponse(call: Call<List<ProductModel>>, response: Response<List<ProductModel>>)
            {
                Log.d("Response", "onResponse: ${response.body()}")
                val res = response.body()
                if(response.code() == 200 && res!=null)
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

    fun fetchShoes(): LiveData<List<ProductModel>>
    {
        val data = MutableLiveData<List<ProductModel>>()
        apiInterface?.fetchShoes()?.enqueue(object: Callback<List<ProductModel>>
        {
            override fun onResponse(call: Call<List<ProductModel>>, response: Response<List<ProductModel>>)
            {
                Log.d("Response", "onResponse: ${response.body()}")
                val res = response.body()
                if(response.code() == 200 && res!=null)
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

    fun fetchTops(): LiveData<List<ProductModel>>
    {
        val data = MutableLiveData<List<ProductModel>>()
        apiInterface?.fetchTops()?.enqueue(object: Callback<List<ProductModel>>
        {
            override fun onResponse(call: Call<List<ProductModel>>, response: Response<List<ProductModel>>)
            {
                Log.d("Response", "onResponse: ${response.body()}")
                val res = response.body()
                if(response.code() == 200 && res!=null)
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

    fun searchItems(item: String): LiveData<List<ProductModel>>
    {
        val data = MutableLiveData<List<ProductModel>>()
        apiInterface?.searchItems(item)?.enqueue(object: Callback<List<ProductModel>>
        {
            override fun onResponse(call: Call<List<ProductModel>>, response: Response<List<ProductModel>>)
            {
                Log.d("Response", "onResponse: ${response.body()}")
                val res = response.body()
                if(response.code() == 200 && res!=null)
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
}