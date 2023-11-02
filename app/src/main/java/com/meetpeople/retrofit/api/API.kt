package com.meetpeople.retrofit.api

import com.meetpeople.domain.TextResponse
import com.meetpeople.retrofit.RetrofitResponse

interface API<T> {
    suspend fun fetchAll(token: String): RetrofitResponse<List<T>>
    suspend fun fetchOne(token: String, id: Long): RetrofitResponse<T>
    suspend fun create(token: String, t: T): RetrofitResponse<T>
    suspend fun update(token: String, id: Long, t: T): RetrofitResponse<T>
    suspend fun delete(token: String, id: Long): RetrofitResponse<TextResponse>
}