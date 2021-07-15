package com.picpay.desafio.android.domain.use_case

import com.picpay.desafio.android.domain.boundary.UserRepository

class GetUsersList constructor(
    private val userRepository: UserRepository
) {

    suspend fun execute() = userRepository.getUsersList()
}