package com.picpay.desafio.android.data.entity

import com.google.gson.annotations.SerializedName
import com.picpay.desafio.android.domain.entity.user.User

data class ApiUser(
    @SerializedName("img") val img: String,
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: Int,
    @SerializedName("username") val username: String
) {

    fun toDomainObject() = User(
        id = id,
        img = img,
        name = name,
        username = username
    )
}