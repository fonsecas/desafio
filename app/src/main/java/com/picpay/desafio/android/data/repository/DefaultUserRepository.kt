package com.picpay.desafio.android.data.repository

import com.picpay.desafio.android.data.client.ApiClient
import com.picpay.desafio.android.domain.boundary.UserRepository
import com.picpay.desafio.android.domain.entity.user.User

class DefaultUserRepository constructor(
    private val apiClient: ApiClient
) : UserRepository {

    override suspend fun getUsersList(): List<User>? {
        return apiClient.getUsersList()?.map { it.toDomainObject() }
    }
}