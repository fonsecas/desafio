package com.picpay.desafio.android.domain.entity.error

import org.junit.Test

internal class HttpErrorTypeTest {

    //  |  Casos |                     Descrição                                              |
    //  |:-------|:---------------------------------------------------------------------------|
    //  | Caso 1 |   Dado uma classe User da camada de data                                   |
    //  |        |   Quando mapearmos ela para o seu correspondente na camada de domain       |
    //  |        |   Entao devemos assegurar que o objeto resultado é o esperado              |

    @Test
    fun case1() {
        val expectedError = HttpErrorType.UNAUTHORIZED

        val currentSUT = HttpErrorType.getErrorForCode(401)

        assert(currentSUT == expectedError)
    }

    @Test
    fun case2() {
        val expectedError = HttpErrorType.TOO_MANY_REQUESTS

        val currentSUT = HttpErrorType.getErrorForCode(409)

        assert(currentSUT == expectedError)
    }
}