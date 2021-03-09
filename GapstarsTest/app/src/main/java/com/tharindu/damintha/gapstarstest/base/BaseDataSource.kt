package com.tharindu.damintha.gapstarstest.base

import com.apollographql.apollo.api.Response
import com.tharindu.damintha.gapstarstest.data.sources.Result

/**
 * Abstract Base Data source class with error handling
 */
abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Result<T> {
        try {
            val response = call()
            if (!response.hasErrors()) {
                val body = response.data
                if (body != null) return Result.success(body)
            }
            return error(response.errors?.get(0)?.message?:"Something went wrong")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Result<T> {
        return Result.error("Network call has failed for a following reason: $message")
    }

}