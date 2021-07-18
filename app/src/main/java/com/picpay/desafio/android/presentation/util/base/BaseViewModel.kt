package com.picpay.desafio.android.presentation.util.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.picpay.desafio.android.presentation.util.placeholder.Placeholder
import com.picpay.desafio.android.presentation.util.placeholder.types.Hide
import com.picpay.desafio.android.presentation.util.placeholder.types.Loading
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent

abstract class BaseViewModel : ViewModel(), KoinComponent {

    val placeholder: LiveData<Placeholder> get() = _placeholder

    private val _placeholder by lazy { MutableLiveData<Placeholder>() }

    protected fun setPlaceholder(placeholder: Placeholder) {
        _placeholder.postValue(placeholder)
    }

    protected fun launchDataLoad(
        shouldLoad: Boolean = true,
        onFailure: (Throwable) -> Unit = {},
        block: suspend () -> Unit
    ): Job {
        return viewModelScope.launch {
            try {
                if (shouldLoad) setPlaceholder(Loading())
                block()
            } catch (error: Throwable) {
                onFailure(error)
            } finally {
                setPlaceholder(Hide())
            }
        }
    }
}