package com.meetpeople.domain

import kotlinx.serialization.Serializable

@Serializable
data class TextResponse(
    val status: Int,
    val message: String
)
