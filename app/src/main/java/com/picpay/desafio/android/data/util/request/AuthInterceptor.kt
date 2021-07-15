package com.picpay.desafio.android.data.util.request

import com.picpay.desafio.android.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import java.nio.charset.StandardCharsets.UTF_8
import java.security.MessageDigest
import java.util.*

class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val timestamp = Date().time.toString()
        //val encryptionString = timestamp + BuildConfig.PRIVATE_KEY + BuildConfig.ACCESS_KEY
        val originalUrl = chain.request().url
        val queriedUrl = originalUrl
//            .newBuilder()
//            .addQueryParameter(API_KEY_QUERY_PARAMETER, BuildConfig.ACCESS_KEY)
//            .addQueryParameter(TIMESTAMP_QUERY_PARAMETER, timestamp)
//            .addQueryParameter(HASH_QUERY_PARAMETER, md5Encryption(encryptionString))
//            .build()
        val queriedBuilder = chain.request().newBuilder().url(queriedUrl).build()
        return chain.proceed(queriedBuilder)
    }

    private fun md5Encryption(str: String): String {
        val md5ByteArray = MessageDigest.getInstance(MD5_ALGORITHM).digest(str.toByteArray(UTF_8))
        return md5ByteArray.toHex()
    }

    private fun ByteArray.toHex() = joinToString("") { "%02x".format(it) }

    companion object {
        const val API_KEY_QUERY_PARAMETER = "apikey"
        const val TIMESTAMP_QUERY_PARAMETER = "ts"
        const val HASH_QUERY_PARAMETER = "hash"
        const val MD5_ALGORITHM = "MD5"
    }
}