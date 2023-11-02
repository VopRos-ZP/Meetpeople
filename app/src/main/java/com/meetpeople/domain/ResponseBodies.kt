package com.meetpeople.domain

data class ResponseBodies<T>(
    val success: Response<T>?,
    val error: TextResponse?
) {

    suspend fun onError(block: suspend (TextResponse) -> Unit) {
        if (error != null) { block(error) }
    }

    suspend fun onSuccess(block: suspend (Response<T>) -> Unit) {
        if (success != null) { block(success) }
    }

}
