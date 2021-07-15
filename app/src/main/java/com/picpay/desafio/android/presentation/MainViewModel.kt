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
//
//    private val url = "https://609a908e0f5a13001721b74e.mockapi.io/picpay/api/"
//
//    private val gson: Gson by lazy { GsonBuilder().create() }
//
//    private val okHttp: OkHttpClient by lazy {
//        OkHttpClient.Builder()
//            .build()
//    }
//
//    private val retrofit: Retrofit by lazy {
//        Retrofit.Builder()
//            .baseUrl(url)
//            .client(okHttp)
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .build()
//    }
//
//    private val service: ApiService by lazy {
//        retrofit.create(ApiService::class.java)
//    }

    init {
        launchDataLoad(onFailure = ::onFailure) {
                _users.value = getUsersList.execute()
        }
//        service.getUsers()
//            .enqueue(object : Callback<List<User>> {
//                override fun onFailure(call: Call<List<User>>, t: Throwable) {
//
//                }
//
//                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
//                    _users.value = response.body()!!
//                }
//            })
    }
    private fun onFailure(throwable: Throwable) {
        setDialog(throwable){}
    }
}