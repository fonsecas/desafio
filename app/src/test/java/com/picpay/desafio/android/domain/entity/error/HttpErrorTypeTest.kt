package com.picpay.desafio.android.domain.entity.error

import org.junit.Test

internal class HttpErrorTypeTest {

    @Test
    fun `when errorCore is 401 then  HttpErrorType should be UNAUTHORIZED`() {
        val expectedError = HttpErrorType.UNAUTHORIZED

        val currentSUT = HttpErrorType.getErrorForCode(401)

        assert(currentSUT == expectedError)
    }

    @Test
    fun `when errorCore is 409 then  HttpErrorType should be TOO_MANY_REQUESTS`() {
        val expectedError = HttpErrorType.TOO_MANY_REQUESTS

        val currentSUT = HttpErrorType.getErrorForCode(409)

        assert(currentSUT == expectedError)
    }
}