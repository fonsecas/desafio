package com.picpay.desafio.android.domain.use_case

import com.picpay.desafio.android.domain.boundary.UserRepository
import com.picpay.desafio.android.domain.entity.user.User

class GetUsersList : UserRepository {
    override suspend fun getUsersList(): List<User?>? {
        return getUsersList()
    }
}