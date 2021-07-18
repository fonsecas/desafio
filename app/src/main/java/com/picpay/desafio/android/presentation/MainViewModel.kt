package com.picpay.desafio.android.presentation

import androidx.lifecycle.LiveData
import com.picpay.desafio.android.domain.entity.user.User
import com.picpay.desafio.android.domain.use_case.IGetUsersList
import com.picpay.desafio.android.presentation.util.arch.SingleLiveEvent
import com.picpay.desafio.android.presentation.util.base.BaseViewModel


class MainViewModel constructor(
    private val interector: IGetUsersList,
) : BaseViewModel() {

    val users: LiveData<List<User?>> get() = _users

    private val _users by lazy { SingleLiveEvent<List<User?>>() }

    init {
        getUsers()
    }

    fun getUsers() {
        launchDataLoad {
            _users.value = interector.getUsersList()
        }
    }


}