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

    fun fetchAllProducts(): LiveData<List<GetModel>>
    {
        val data = MutableLiveData<List<GetModel>>()
        apiInterface?.fetchAllProducts()?.enqueue(object: Callback<List<GetModel>>
        {
            override fun onResponse(call: Call<List<GetModel>>, response: Response<List<GetModel>>)
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

            override fun onFailure(call: Call<List<GetModel>>, t: Throwable) {
                data.value = null
            }

        })
        return data
    }

    fun fetchOnSaleProducts(): LiveData<List<GetModel>>
    {
        val data = MutableLiveData<List<GetModel>>()
        apiInterface?.fetchOnSaleProducts()?.enqueue(object: Callback<List<GetModel>>
        {
            override fun onResponse(call: Call<List<GetModel>>, response: Response<List<GetModel>>)
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

            override fun onFailure(call: Call<List<GetModel>>, t: Throwable) {
                data.value = null
            }

        })
        return data
    }

    fun fetchNewProducts(): LiveData<List<GetModel>>
    {
        val data = MutableLiveData<List<GetModel>>()
        apiInterface?.fetchNewProducts()?.enqueue(object: Callback<List<GetModel>>
        {
            override fun onResponse(call: Call<List<GetModel>>, response: Response<List<GetModel>>)
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

            override fun onFailure(call: Call<List<GetModel>>, t: Throwable) {
                data.value = null
            }

        })
        return data
    }

    fun fetchBags(): LiveData<List<GetModel>>
    {
        val data = MutableLiveData<List<GetModel>>()
        apiInterface?.fetchBags()?.enqueue(object: Callback<List<GetModel>>
        {
            override fun onResponse(call: Call<List<GetModel>>, response: Response<List<GetModel>>)
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

            override fun onFailure(call: Call<List<GetModel>>, t: Throwable) {
                data.value = null
            }

        })
        return data
    }

    fun fetchBottoms(): LiveData<List<GetModel>>
    {
        val data = MutableLiveData<List<GetModel>>()
        apiInterface?.fetchBottoms()?.enqueue(object: Callback<List<GetModel>>
        {
            override fun onResponse(call: Call<List<GetModel>>, response: Response<List<GetModel>>)
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

            override fun onFailure(call: Call<List<GetModel>>, t: Throwable) {
                data.value = null
            }

        })
        return data
    }

    fun fetchBoys(): LiveData<List<GetModel>>
    {
        val data = MutableLiveData<List<GetModel>>()
        apiInterface?.fetchBoys()?.enqueue(object: Callback<List<GetModel>>
        {
            override fun onResponse(call: Call<List<GetModel>>, response: Response<List<GetModel>>)
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

            override fun onFailure(call: Call<List<GetModel>>, t: Throwable) {
                data.value = null
            }

        })
        return data
    }

    fun fetchDresses(): LiveData<List<GetModel>>
    {
        val data = MutableLiveData<List<GetModel>>()
        apiInterface?.fetchDresses()?.enqueue(object: Callback<List<GetModel>>
        {
            override fun onResponse(call: Call<List<GetModel>>, response: Response<List<GetModel>>)
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

            override fun onFailure(call: Call<List<GetModel>>, t: Throwable) {
                data.value = null
            }

        })
        return data
    }

    fun fetchGirls(): LiveData<List<GetModel>>
    {
        val data = MutableLiveData<List<GetModel>>()
        apiInterface?.fetchGirls()?.enqueue(object: Callback<List<GetModel>>
        {
            override fun onResponse(call: Call<List<GetModel>>, response: Response<List<GetModel>>)
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

            override fun onFailure(call: Call<List<GetModel>>, t: Throwable) {
                data.value = null
            }

        })
        return data
    }

    fun fetchMenBottoms(): LiveData<List<GetModel>>
    {
        val data = MutableLiveData<List<GetModel>>()
        apiInterface?.fetchMenBottoms()?.enqueue(object: Callback<List<GetModel>>
        {
            override fun onResponse(call: Call<List<GetModel>>, response: Response<List<GetModel>>)
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

            override fun onFailure(call: Call<List<GetModel>>, t: Throwable) {
                data.value = null
            }

        })
        return data
    }

    fun fetchMenTops(): LiveData<List<GetModel>>
    {
        val data = MutableLiveData<List<GetModel>>()
        apiInterface?.fetchMenTops()?.enqueue(object: Callback<List<GetModel>>
        {
            override fun onResponse(call: Call<List<GetModel>>, response: Response<List<GetModel>>)
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

            override fun onFailure(call: Call<List<GetModel>>, t: Throwable) {
                data.value = null
            }

        })
        return data
    }

    fun fetchShoes(): LiveData<List<GetModel>>
    {
        val data = MutableLiveData<List<GetModel>>()
        apiInterface?.fetchShoes()?.enqueue(object: Callback<List<GetModel>>
        {
            override fun onResponse(call: Call<List<GetModel>>, response: Response<List<GetModel>>)
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

            override fun onFailure(call: Call<List<GetModel>>, t: Throwable) {
                data.value = null
            }

        })
        return data
    }

    fun fetchTops(): LiveData<List<GetModel>>
    {
        val data = MutableLiveData<List<GetModel>>()
        apiInterface?.fetchTops()?.enqueue(object: Callback<List<GetModel>>
        {
            override fun onResponse(call: Call<List<GetModel>>, response: Response<List<GetModel>>)
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

            override fun onFailure(call: Call<List<GetModel>>, t: Throwable) {
                data.value = null
            }

        })
        return data
    }
}