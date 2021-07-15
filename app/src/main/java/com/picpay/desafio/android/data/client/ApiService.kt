package com.picpay.desafio.android.data.client

import com.picpay.desafio.android.data.entity.ApiUser
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsersList(): Response<List<ApiUser>>
}