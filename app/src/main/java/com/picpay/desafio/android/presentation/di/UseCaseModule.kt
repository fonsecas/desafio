package com.picpay.desafio.android.presentation.di

import com.picpay.desafio.android.domain.interector.GetUsersList
import com.picpay.desafio.android.domain.interector.IGetUsersList
import org.koin.dsl.module

fun useCaseModule() = module {

    single {
        GetUsersList(get()) as IGetUsersList
    }

}