package com.picpay.desafio.android.data.util.request

import com.picpay.desafio.android.domain.entity.error.RequestException
import kotlinx.coroutines.coroutineScope
import retrofit2.Response
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

open class RequestHandler {
    protected suspend fun <T : Any> makeRequest(block: Response<T>): T? {
        return coroutineScope {
            try {
                block.run {
                    if (isSuccessful) {
                        body()
                    } else {
                        throw RequestException.HttpError(code())
                    }
                }
            } catch (t: Exception) {
                throw when (t) {
                    is RequestException -> t
                    is SocketTimeoutException -> RequestException.TimeoutError()
                    is UnknownHostException -> RequestException.NetworkError()
                    is IOException -> RequestException.NetworkError()
                    else -> RequestException.UnexpectedError()
                }
            }
        }
    }
}