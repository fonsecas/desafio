package com.picpay.desafio.android

import com.picpay.desafio.android.client.PicPayService
import com.picpay.desafio.android.entity.User

class ExampleService(
    private val service: PicPayService
) {

    fun example(): List<User> {
        val users = service.getUsers().execute()

        return users.body() ?: emptyList()
    }
}