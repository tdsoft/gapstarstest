package com.tharindu.damintha.gapstarstest.utils

import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer a06a0903a68b3ed21ae2019dfa3e443ba20cfa0d")
            .build()

        return chain.proceed(request)
    }
}