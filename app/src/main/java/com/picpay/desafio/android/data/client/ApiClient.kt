package com.picpay.desafio.android.data.client

import com.picpay.desafio.android.data.entity.ApiUser
import com.picpay.desafio.android.data.util.request.RequestHandler

class ApiClient constructor(
    private val apiService: ApiService
) : RequestHandler() {

    suspend fun getUsersList(): List<ApiUser>? {
        return makeRequest(apiService.getUsersList())
    }
}