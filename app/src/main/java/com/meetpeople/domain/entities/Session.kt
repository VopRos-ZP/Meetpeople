package com.meetpeople.domain.entities

import kotlinx.serialization.Serializable

@Serializable
data class Session(
    val id: Long,
    val loginDate: Long,
    val ipAddress: String
)
