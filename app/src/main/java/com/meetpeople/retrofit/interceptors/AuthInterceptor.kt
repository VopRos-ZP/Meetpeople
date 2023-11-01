package com.meetpeople.retrofit.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val jwt: String?) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val request = when (jwt == null) {
            true -> original
            else -> {
                original.newBuilder()
                    .addHeader("Authorization", "Bearer $jwt")
                    .method(original.method, original.body)
                    .build()
            }
        }
        return chain.proceed(request)
    }
}