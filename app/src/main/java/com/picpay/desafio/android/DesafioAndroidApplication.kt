package com.picpay.desafio.android

import android.app.Application
import com.picpay.desafio.android.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DesafioAndroidApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@DesafioAndroidApplication)
            modules(
                listOf(
                    viewModelModule()
                )
            )
        }
    }
}