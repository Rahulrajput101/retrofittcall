package com.example.android.retrofittcall.repositary

import com.example.android.retrofittcall.api.RetrofitInstance
import com.example.android.retrofittcall.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost():Response<Post> {
       return RetrofitInstance.api.getPost()
    }

    suspend fun getPost2(number: Int): Response<Post>{
        return RetrofitInstance.api.getPost2(number)
    }

    suspend fun myCustomPost(userId: Int): Response<List<Post>>{
        return RetrofitInstance.api.getCustomPost(userId)
    }

    suspend fun myCustomPost2(userId: Int, option: Map<String, String>): Response<List<Post>>{
        return RetrofitInstance.api.getCustomPost2(userId,option)
    }





}