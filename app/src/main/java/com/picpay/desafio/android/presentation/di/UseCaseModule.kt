package com.picpay.desafio.android.presentation.di

import com.picpay.desafio.android.domain.use_case.GetUsersList
import org.koin.dsl.module

fun useCaseModule() = module {
    single {
        GetUsersList(get())
    }
}