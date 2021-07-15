package com.picpay.desafio.android.presentation.di

import com.picpay.desafio.android.data.repository.DefaultUserRepository
import com.picpay.desafio.android.domain.boundary.UserRepository
import org.koin.dsl.module

fun repositoryModule() = module {

    single {
        DefaultUserRepository(get()) as UserRepository
    }
}