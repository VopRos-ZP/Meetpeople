package com.meetpeople.retrofit

import com.meetpeople.domain.TextResponse
import kotlinx.serialization.json.Json
import retrofit2.Response

typealias RetrofitResponse<T> = Response<com.meetpeople.domain.Response<T>>

fun <T> Response<T>.errorResponse(): TextResponse = errorBody().let {
    when (it) {
        null -> TextResponse(401, "")
        else -> Json.decodeFromString(it.string())
    }
}