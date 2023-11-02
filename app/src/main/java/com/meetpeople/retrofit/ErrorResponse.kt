package com.meetpeople.retrofit

import com.meetpeople.domain.ResponseBodies
import com.meetpeople.domain.TextResponse
import kotlinx.serialization.json.Json
import retrofit2.Response

typealias RetrofitResponse<T> = Response<com.meetpeople.domain.Response<T>>

fun <T> bodies(response: RetrofitResponse<T>): ResponseBodies<T> {
    return ResponseBodies(response.body(), response.errorResponse())
}

fun <T> Response<T>.errorResponse(): TextResponse? = errorBody().let {
    if (it != null) Json.decodeFromString(it.string()) as TextResponse
    null
}