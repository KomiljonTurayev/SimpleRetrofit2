package com.example.simpleretrofit2.repository

import com.example.simpleretrofit2.api.RetrofitInstance
import com.example.simpleretrofit2.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }
}