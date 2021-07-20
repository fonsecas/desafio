package com.picpay.desafio.android.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.picpay.desafio.android.domain.entity.user.User
import com.picpay.desafio.android.domain.interector.IGetUsersList
import com.picpay.desafio.android.presentation.util.base.BaseViewModel

class MainViewModel constructor(
    private val interector: IGetUsersList,
) : BaseViewModel() {

    val users: LiveData<List<User?>?> get() = _users

    private val _users by lazy { MutableLiveData<List<User?>?>() }

    init {
        getUsers()
    }

    fun getUsers() {
        launchDataLoad {
            _users.value = interector.getUsersList()
        }
    }


}