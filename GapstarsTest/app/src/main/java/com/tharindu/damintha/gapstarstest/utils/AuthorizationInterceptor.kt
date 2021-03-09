package com.tharindu.damintha.gapstarstest.utils

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor(): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer 134332ad4c3f03b5108575a3f3d3c50dae43a575")
            .build()

        return chain.proceed(request)
    }
}