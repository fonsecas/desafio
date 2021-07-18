package com.picpay.desafio.android.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.picpay.desafio.android.domain.entity.user.User
import com.picpay.desafio.android.domain.use_case.GetUsersList
import com.picpay.desafio.android.presentation.util.base.BaseViewModel


class MainViewModel constructor(
    private val getUsersList: GetUsersList
) : BaseViewModel() {

    val users: LiveData<MainViewState> get() = _users

    private val _users by lazy { MutableLiveData<MainViewState>() }

    init {
        getUsers()
    }

    fun getUsers() {
        _users.value = MainViewState.Loading
        launchDataLoad(onFailure = ::onFailure) {
            getUsersList.execute()?.apply {
                _users.value = MainViewState.Success(this)
            }
        }
    }


    private fun onFailure(throwable: Throwable) {
        setDialog(throwable) {}
    }

sealed class MainViewState {
    object Loading : MainViewState()
    data class Error(val throwable: Throwable) : MainViewState()
    data class Success(val data: List<User?>?) : MainViewState()
}
}