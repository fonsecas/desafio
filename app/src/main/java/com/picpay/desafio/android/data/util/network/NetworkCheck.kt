package com.picpay.desafio.android.data.util.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

val cacheSize = (5 * 1024 * 1024).toLong()

fun hasNetwork(context: Context): Boolean? {
    var isConnected: Boolean? = false
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
    if (activeNetwork != null && activeNetwork.isConnected)
        isConnected = true
    return isConnected
}