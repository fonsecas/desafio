package com.picpay.desafio.android.presentation.di

import com.picpay.desafio.android.presentation.view.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun viewModelModule() = module {

    viewModel {
        MainViewModel(get())
    }
}