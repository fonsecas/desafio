package com.picpay.desafio.android.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.picpay.desafio.android.domain.entity.user.User
import com.picpay.desafio.android.domain.use_case.GetUsersList
import com.picpay.desafio.android.presentation.util.base.BaseViewModel


class MainViewModel constructor(
    private val getUsersList: GetUsersList
) : BaseViewModel() {

    val users: LiveData<List<User?>> get() = _users

    private val _users by lazy { MutableLiveData<List<User?>>() }

    init {
        getUsers()
    }

    fun getUsers() {
        launchDataLoad(onFailure = ::onFailure) {
            _users.value = getUsersList.execute()
        }
    }

    private fun onFailure(throwable: Throwable) {
        setDialog(throwable) {}
    }
}