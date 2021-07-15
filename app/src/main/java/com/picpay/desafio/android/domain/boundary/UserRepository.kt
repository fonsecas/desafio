package com.picpay.desafio.android.domain.boundary

import com.picpay.desafio.android.domain.entity.user.User

interface UserRepository {
    suspend fun getUsersList(): List<User?>?
}