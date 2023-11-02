package com.meetpeople.domain

import kotlinx.serialization.Serializable

@Serializable
data class Response<T>(
    val token: String,
    val result: T
)