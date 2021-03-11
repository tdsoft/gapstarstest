package com.tharindu.damintha.gapstarstest.utils

import com.tharindu.damintha.gapstarstest.common.GIT_KEY
import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer $GIT_KEY")
            .build()

        return chain.proceed(request)
    }
}