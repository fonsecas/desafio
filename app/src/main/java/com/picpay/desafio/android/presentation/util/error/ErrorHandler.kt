package com.picpay.desafio.android.presentation.util.error

import android.content.Context
import androidx.annotation.StringRes
import com.picpay.desafio.android.R
import com.picpay.desafio.android.domain.entity.error.HttpErrorType
import com.picpay.desafio.android.domain.entity.error.RequestException
import com.picpay.desafio.android.presentation.util.dialog.DialogData
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class ErrorHandler constructor(private val context: Context) {

    fun getDialogData(throwable: Throwable, retryAction: (() -> Unit)): DialogData? {
        val errorString = getErrorString(throwable)
        return errorString?.let {
            DialogData.error(context, it, res(R.string.global_try_again), retryAction)
        }
    }

    private fun getErrorString(throwable: Throwable): String? {
        return if (throwable is RequestException) getStringFromRequestException(throwable)
        else getStringFromNonRequestException(throwable)
    }

    private fun getStringFromRequestException(throwable: RequestException): String? {
        return when {
            throwable is RequestException.TimeoutError -> res(R.string.error_timeout)
            throwable is RequestException.NetworkError -> res(R.string.error_network)
            throwable is RequestException.UnexpectedError -> res(R.string.error_unexpected)
            throwable.httpErrorType == HttpErrorType.UNAUTHORIZED -> res(R.string.error_unauthorized)
            throwable.httpErrorType == HttpErrorType.TOO_MANY_REQUESTS -> res(R.string.error_too_many_requests)
            else -> null
        }
    }

    private fun getStringFromNonRequestException(throwable: Throwable): String? {
        return when (throwable) {
            is SocketTimeoutException -> res(R.string.error_timeout)
            is UnknownHostException -> res(R.string.error_network)
            is IOException -> res(R.string.error_network)
            else -> null
        }
    }

    private fun res(@StringRes stringId: Int) = context.getString(stringId)
}