package com.example.android.retrofittcall.api

import com.example.android.retrofittcall.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object RetrofitInstance {

    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    val api : SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }



}