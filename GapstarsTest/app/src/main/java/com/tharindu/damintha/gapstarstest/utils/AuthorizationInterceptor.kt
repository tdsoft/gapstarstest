package com.tharindu.damintha.gapstarstest.utils

import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer c2353ea9bb1fac4a5a7d987f080b3d26ad05263e")
            .build()

        return chain.proceed(request)
    }
}