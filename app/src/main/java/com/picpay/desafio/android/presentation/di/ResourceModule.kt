package com.picpay.desafio.android.presentation.di

import com.picpay.desafio.android.presentation.util.error.ErrorHandler
import org.koin.dsl.module

fun resourceModule() = module {

    single {
        ErrorHandler(get())
    }

}
