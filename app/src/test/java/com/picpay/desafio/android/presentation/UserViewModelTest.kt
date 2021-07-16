package com.picpay.desafio.android.presentation

import com.picpay.desafio.android.data.entity.ApiUser
import com.picpay.desafio.android.domain.entity.user.User
import org.junit.Test

internal class UserViewModelTest {
    @Test
    fun `when view model getUsers get success then sets usersLiveData`() {
        val expectedSUT = User(
            id = 1,
            img = "https://randomuser.me/api/portraits/men/2.jpg",
            name = "name",
            username = "username"

        )
        val currentSUT = ApiUser(
            id = 1,
            img = "https://randomuser.me/api/portraits/men/2.jpg",
            name = "name",
            username = "username"
        ).toDomainObject()

        assert(expectedSUT == currentSUT)
    }
}