package com.picpay.desafio.android.domain.entity.user

import java.io.Serializable

data class User(
    val id: Int,
    val img: String,
    val name: String,
    val username: String,
) : Serializable