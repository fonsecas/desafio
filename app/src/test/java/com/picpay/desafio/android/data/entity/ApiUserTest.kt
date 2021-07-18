package com.picpay.desafio.android.data.entity

import com.picpay.desafio.android.domain.entity.user.User
import org.junit.Test

internal class ApiUserTest {

    //  |  Casos |                     Descrição                                              |
    //  |:-------|:---------------------------------------------------------------------------|
    //  | Caso 1 |   Dado uma classe User da camada de data                                   |
    //  |        |   Quando mapearmos ela para o seu correspondente na camada de domain       |
    //  |        |   Entao devemos assegurar que o objeto resultado é o esperado              |

    @Test
    fun case1() {
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