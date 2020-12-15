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

    fun fetchNewProducts(): LiveData<List<GetModel>>
    {
        val data = MutableLiveData<List<GetModel>>()
        apiInterface?.fetchNewProducts()?.enqueue(object: Callback<List<GetModel>>
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
}