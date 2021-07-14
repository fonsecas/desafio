package com.picpay.desafio.android.di

import com.picpay.desafio.android.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun viewModelModule() = module {

    viewModel {
        MainViewModel()
    }
}