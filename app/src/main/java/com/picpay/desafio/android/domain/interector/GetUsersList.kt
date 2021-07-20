package com.picpay.desafio.android.domain.interector

import com.picpay.desafio.android.domain.boundary.UserRepository
import com.picpay.desafio.android.domain.entity.user.User

interface IGetUsersList {
    suspend fun getUsersList(): List<User?>?
}

class GetUsersList(private val repository: UserRepository) : IGetUsersList {
    override suspend fun getUsersList(): List<User?>? {
        return repository.getUsersList()
    }
}


