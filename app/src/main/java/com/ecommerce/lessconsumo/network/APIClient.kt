package com.example.lesscon.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASEURL = "https://lessconsumo.com/wp-json/wc/v3/"
class APIClient
{
    companion object
    {
        private var retrofit: Retrofit? = null
        fun getApiClient(): Retrofit
        {
            val gson = GsonBuilder()
                .setLenient()
                .create()
            val okHttpClient = OkHttpClient.Builder()
                .readTimeout(100, TimeUnit.SECONDS)
                .connectTimeout(100, TimeUnit.SECONDS)
                .addInterceptor(BasicAuthInterceptor("ck_72a51f4673459c93a8974fd0b7d75ec90a71b78d", "cs_b6a131fb6669a438555e39db478b96925c63777f"))
                .build()

            if(retrofit == null)
            {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
            }
            return retrofit!!
        }
    }
}