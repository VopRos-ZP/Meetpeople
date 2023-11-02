package com.meetpeople.domain

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    val phone: String,
    val password: String
)
